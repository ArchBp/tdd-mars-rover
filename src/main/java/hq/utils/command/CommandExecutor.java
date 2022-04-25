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

        ForwardCommandHandler forwardCommandHandler = new ForwardCommandHandler();
        BackwardCommandHandler backwardCommandHandler = new BackwardCommandHandler();
        forwardCommandHandler.next(backwardCommandHandler);
        forwardCommandHandler.child(forwardMovementHandlerChainCreator.getChain());
        LeftCommandHandler leftCommandHandler = new LeftCommandHandler();
        backwardCommandHandler.next(leftCommandHandler);
        backwardCommandHandler.child(backwardMovementHandlerChainCreator.getChain());
        RightCommandHandler rightCommandHandler = new RightCommandHandler();
        leftCommandHandler.next(rightCommandHandler);
        leftCommandHandler.child(new LeftMovementHandler());
        UnknownCommandHandler unknownCommandHandler = new UnknownCommandHandler();
        rightCommandHandler.next(unknownCommandHandler);
        rightCommandHandler.child(new RightMovementHandler());

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
