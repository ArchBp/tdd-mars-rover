package hq.utils.command;

import hq.Rover;
import hq.utils.command.handler.*;
import hq.utils.movement.chain.BackwardMovementHandlerChainCreator;
import hq.utils.movement.chain.ForwardMovementHandlerChainCreator;
import hq.utils.movement.handler.left.LeftMovementHandler;
import hq.utils.movement.handler.right.RightMovementHandler;

public class CommandExecutor {
    private static CommandExecutor instance;
    CommandHandler commandHandler;

    private CommandExecutor() {

        final BackwardMovementHandlerChainCreator backwardMovementHandlerChainCreator = BackwardMovementHandlerChainCreator.getInstance();
        final ForwardMovementHandlerChainCreator forwardMovementHandlerChainCreator = ForwardMovementHandlerChainCreator.getInstance();
        final LeftMovementHandler leftMovementHandler = new LeftMovementHandler();
        final RightMovementHandler rightMovementHandler = new RightMovementHandler();

        ForwardCommandHandler forwardCommandHandler = new ForwardCommandHandler();
        BackwardCommandHandler backwardCommandHandler = new BackwardCommandHandler();
        RightCommandHandler rightCommandHandler = new RightCommandHandler();
        LeftCommandHandler leftCommandHandler = new LeftCommandHandler();
        UnknownCommandHandler unknownCommandHandler = new UnknownCommandHandler();

        forwardCommandHandler.next(backwardCommandHandler);
        forwardCommandHandler.child(forwardMovementHandlerChainCreator.getChain());
        backwardCommandHandler.next(leftCommandHandler);
        backwardCommandHandler.child(backwardMovementHandlerChainCreator.getChain());
        leftCommandHandler.next(rightCommandHandler);
        leftCommandHandler.child(leftMovementHandler);
        rightCommandHandler.next(unknownCommandHandler);
        rightCommandHandler.child(rightMovementHandler);

        commandHandler = forwardCommandHandler;
    }

    public static CommandExecutor getInstance(){
        if(instance == null){
            instance = new CommandExecutor();
        }
        return instance;
    }

    public void execute(char command, Rover rover){
        commandHandler.execute(command, rover);
    }
}
