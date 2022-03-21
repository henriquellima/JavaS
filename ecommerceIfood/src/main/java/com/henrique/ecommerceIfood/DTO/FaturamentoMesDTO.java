package com.henrique.ecommerceIfood.DTO;

public class FaturamentoMesDTO {
    private Integer mes;
    private Double total;
    private Long qtdPedidos;

    public FaturamentoMesDTO() {

    }

    public FaturamentoMesDTO(Integer mes, Double total, Long qtdPedidos) {
        this.mes = mes;
        this.total = total;
        this.qtdPedidos = qtdPedidos;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getQtdPedidos() {
        return qtdPedidos;
    }

    public void setQtdPedidos(Long qtdPedidos) {
        this.qtdPedidos = qtdPedidos;
    }
}
