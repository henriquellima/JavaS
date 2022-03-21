package com.henrique.ecommerceIfood.DTO;

public class FormPermissaoDTO {
    String usuarioEmail;
    String permissaoNome;

    public FormPermissaoDTO(String usuarioEmail, String permissaoNome) {
        this.usuarioEmail = usuarioEmail;
        this.permissaoNome = permissaoNome;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getPermissaoNome() {
        return permissaoNome;
    }

    public void setPermissaoNome(String permissaoNome) {
        this.permissaoNome = permissaoNome;
    }
}
