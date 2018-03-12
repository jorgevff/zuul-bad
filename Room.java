import java.util.HashMap;

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
    private HashMap<String, Room> salidas;
    private String description;
    ;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or b
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        salidas = new HashMap<String ,Room>();
    }

    /**
     * Devolvemos el valor de las variables, un objeto de la clase Room
     * introduciendo como parametro una cadena que es la direccion a seguir.
     */
    public Room getExit(String direccionSalida)
    {
        Room roomActual = null;
        if(direccionSalida.equals("north")){
            roomActual = salidas.get("north");
        }
        if(direccionSalida.equals("south")){
            roomActual = salidas.get("south");
        }
        if(direccionSalida.equals("east")){
            roomActual = salidas.get("east");
        }
        if(direccionSalida.equals("west")){
            roomActual = salidas.get("west");
        }
        if(direccionSalida.equals("southEast")){
            roomActual = salidas.get("southEast");
        }
        if(direccionSalida.equals("northWest")){
            roomActual = salidas.get("northWest");
        }

        return roomActual;
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor The room in the given direction.
     */
    public void setExit(String direccion, Room nuevaRoom)
    {
        salidas.put(direccion, nuevaRoom);

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
        if(salidas.get("north") != null) {
            salida = salida + "north ";
        }
        if(salidas.get("east") != null) {
            salida = salida + "east ";
        }
        if(salidas.get("south") != null) {
            salida = salida + "south ";
        }
        if(salidas.get("west") != null) {
            salida = salida +  "west ";
        }
        if(salidas.get("southEast") !=null){
            salida = salida + "southEast ";
        }
        if(salidas.get("northWest") !=null){
            salida = salida + "northWest ";
        }

        return salida;
    }

    /**
     * Return a long description of this room, of the form:
     *     You are in the 'name of room'
     *     Exits: north west southwest
     * @return A description of the room, including exits.
     */
    public String getLongDescription()
    {
        String descripccion = "You are " + description;
        descripccion = descripccion + ".\n" + getExitString();
        return descripccion;
    }

}
