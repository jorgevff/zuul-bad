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
            salidas.put("north", north);
        if(east != null)
            salidas.put("east", east);
        if(south != null)
            salidas.put("south", south);
        if(west != null)
            salidas.put("west", west);
        if(southEast != null)
            salidas.put("southEast", southEast);
        if(northWest != null)
            salidas.put("northWest", northWest);
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
        


}
