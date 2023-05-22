public class Data {
    private String nome;
    private double simpatia;
    private double elegancia;
    private double beleza;
    private double media;

    public void setNome(String name){
        this.nome = name;
    }

    public String getNome(){
        return nome;
    }

    public void setSimpatia(double simpatic){
        this.simpatia = simpatic;
    }

    public double getSimpatia(){
        return simpatia;
    }

    public void setElegancia(double elegancy){ 
        this.elegancia = elegancy;
    }

    public double getElegancia(){
        return elegancia;
    }

    public void setBeleza(double blz){
        this.beleza = blz;
    }

    public double getBeleza(){
        return beleza;
    }

    public double calcularMedia() {
        return (simpatia + elegancia * 3.0 + beleza * 4.0) / 8.0;
    }

    public double getMedia(){
        return this.media;
    }

    public void setMedia(double media){
        this.media = media;
    }
}