package model;

public class Empresa {
    private static Empresa instancia;
    
    private final String nombre;
    private final String nit;
    private final String version;

    private Empresa() {
        this.nombre = "Aniflex";
        this.nit = "900.123.456-7";
        this.version = "v1.0.0 (2026B)";
    }

    public static synchronized Empresa getInstance() {
        if (instancia == null) {
            instancia = new Empresa();
        }
        return instancia;
    }

    public String getNombre() { return nombre; }
    public String getNit() { return nit; }
    public String getVersion() { return version; }
}
