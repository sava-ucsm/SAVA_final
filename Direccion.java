public class Direccion {
    private String distrito;
    private String ciudad;
    //private String provincia;


    public Direccion(String distrito, String ciudad) {
        this.distrito = distrito;
        this.ciudad = ciudad;
    }

    public String getDistrito() {
        return distrito;
    }

    public String getCiudad() {
        return ciudad;
    }


    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public void setciudad(String departamento) {
        this.ciudad = departamento;
    }

    public void modificar(String dist,String  ciu){
        setDistrito(dist);
        setciudad(ciu);
    }

    public boolean equals(Object b) {
        if(!(b instanceof Direccion))
            return false;
        Direccion p =(Direccion) b;
        return this.getDistrito().equals(p.getDistrito()) &&
                this.getCiudad().equals(p.getCiudad());
    }
    @Override
    public String toString() {
        return this.getDistrito()+" "+this.getCiudad();
    }

}
