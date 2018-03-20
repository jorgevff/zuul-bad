
/**
 * Write a description of class Item here.
 * 
 * @author Jorge Valladares 
 * @version (1.0)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String descripcion;
    private float peso;

    /**
     * Constructor for objects of class Item
     */
    public Item(String descripcion, float peso)
    {
        // initialise instance variables
        this.descripcion = descripcion;
        this.peso = peso;
    }

    /**
     * Metodos getter 
     */
     
    public String getDescripcion()
    {
        // put your code here
        return descripcion;
    }
    
    public float getPeso()
    {
        return peso;
    }
}
