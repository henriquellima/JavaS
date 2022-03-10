package models;

import javax.persistence.*;


@Entity
@Table(name = "departamento")
public class pedido {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;


    private String data;
    private double valor_bruto;
    private double desconto;
    private double valor_total;
    private int qtd_Estoque;
    public String link_foto;
    public int cliente_id;



}
