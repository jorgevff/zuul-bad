/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room anteriorUbicacion;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room cabania, tienda, salaTrofeos, lago, rio, costa, acantilado;

        // create the rooms
        cabania = new Room("Me encuentro en mi caba�a para una fructifera jornada!!");
        tienda = new Room("en la tienda del pueblo, necesito cebo");
        salaTrofeos = new Room("En la sala de Trofeos");
        lago = new Room("ya estoy en el lago, voy a realizar un intento...");
        rio = new Room("ya estoy en el rio, voy a realizar un intento...");
        costa = new Room("ya estoy en el mar, voy a realizar un intento...");
        acantilado = new Room("Estoy en el acantilado, casi me caigo!!!!");

        // initialise room exits

        cabania.setExit("east", tienda);
        cabania.setExit("northWest", salaTrofeos);

        tienda.setExit("north", costa);
        tienda.setExit("south", rio);
        tienda.setExit("west", cabania);
        tienda.addItem(new Item("Gusarapines", 0.30f));
        tienda.addItem(new Item("Artificial", 0.45f));
        tienda.addItem(new Item("Sedal monofilamento", 0.100f));

        
        salaTrofeos.setExit("southEast", cabania);

        lago.setExit("west", rio);
        lago.addItem(new Item("Perca", 3.60f));
        lago.addItem(new Item("Siluto", 11.75f));

        rio.setExit("north", tienda);
        rio.setExit("east", lago);
        rio.addItem(new Item("Lucio", 7.60f));
        rio.addItem(new Item("Salmon", 3.50f));
        rio.addItem(new Item("Trucha", 1.80f));
        rio.addItem(new Item("Cangrejo Rojo", 0.50f));

        costa.setExit("south", tienda);
        costa.setExit("southEast", acantilado);
        costa.addItem(new Item("Roca", 0.60f));
        costa.addItem(new Item("Lubina", 4.34f));
        costa.addItem(new Item("Pulpo", 3.80f));

        currentRoom = cabania;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("look")) {
            look();
        }
        else if (commandWord.equals("eat")){
            eat();
        }
        else if (commandWord.equals("back")){
            back();
        }

        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.showCommands());
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            anteriorUbicacion = currentRoom;
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     * Imprime la localizacion en el momento actual e informa donde podemos desplazarmos.
     * Este m�todo no lleva parametros
     */

    private void printLocationInfo()
    {

        System.out.println(currentRoom.getLongDescription());

        System.out.println();

    }

    /**
     * Metodo que muestra donde estamos situados en el momento actual
     * el metodo no tiene parametros
     */

    private void look() 
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Metodo que imprime un mensaje de comer
     */
    private void eat() 
    {
        System.out.println("You have eaten now and you are not hungry any more");
    }

    /**
     * Metodo que vuelve a la sala anterior, si esta en la sala inicial no se mueve
     */
    private void back()
    {
        if(anteriorUbicacion != null){
            currentRoom = anteriorUbicacion; 
            System.out.println(currentRoom.getLongDescription());
        }
    }
}
