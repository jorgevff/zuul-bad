/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */
public class Room 
{
    private String description;
    private Room northExit;
    private Room southExit;
    private Room eastExit;
    private Room westExit;
    private Room southEastExit;
    private Room northWestExit;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or b
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
    }

    /**
     * Devolvemos el valor de las variables, un objeto de la clase Room
     * introduciendo como parametro una cadena que es la direccion a seguir.
     */
    public Room getExit(String direccionSalida)
    {
        Room roomActual = null;
        if(direccionSalida.equals("north")){
            roomActual = northExit;
        }
        if(direccionSalida.equals("south")){
            roomActual = southExit;
        }
        if(direccionSalida.equals("east")){
            roomActual = eastExit;
        }
        if(direccionSalida.equals("west")){
            roomActual = westExit;
        }
        if(direccionSalida.equals("southEast")){
            roomActual = southEastExit;
        }
        if(direccionSalida.equals("northWest")){
            roomActual = northWestExit;
        }

        return roomActual;
    }

    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west, Room southEast, Room northWest) 
    {
        if(north != null)
            northExit = north;
        if(east != null)
            eastExit = east;
        if(south != null)
            southExit = south;
        if(west != null)
            westExit = west;
        if(southEast != null)
            southEastExit = southEast;
        if(northWest != null)
            northWestExit = northWest;
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * Return a description of the room's exits.
     * For example: "Exits: north east west"
     *
     * @ return A description of the available exits.
     */
    public String getExitString()
    {
        String salida = "";
        if(northExit != null) {
            salida = salida + "north ";
        }
        if(eastExit != null) {
            salida = salida + "east ";
        }
        if(southExit != null) {
            salida = salida + "south ";
        }
        if(westExit != null) {
            salida = salida +  "west ";
        }
        if(southEastExit !=null){
            salida = salida + "southEast ";
        }
        if(northWestExit !=null){
            salida = salida + "northWest ";
        }
        
        
        return salida;
    }
        


}
