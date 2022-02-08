package Biblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private String dataPublicacao;
    private String categoria;
    private int armario;
    private int pratileira;
    boolean disponivel = true;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public String setDataPublicacao(String dataPublicacao) {
        return this.dataPublicacao = dataPublicacao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getArmario() {
        return armario;
    }

    public void setArmario(int armario) {
        this.armario = armario;
    }

    public int getPratileira() {
        return pratileira;
    }

    public void setPratileira(int pratileira) {
        this.pratileira = pratileira;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean socilitarEmprestimo(){
        if(disponivel){
        	this.setDisponivel(false);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean devolver() {
        if(!disponivel){
            return true;
        }
        else{
        	this.setDisponivel(true);
            return false;
        }
    }

}
