package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "td_usuarios", schema = "transportadora")
public class Usuario extends AbstractEntity {

    @Getter @Setter
    private BigDecimal percGanho;

    @Getter @Setter
    private String login;

    @Getter @Setter
    private String senha;

    @Getter @Setter
    private Grupo grupo;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private String cpf;

    @Getter @Setter
    private String telefone;

    @Getter @Setter
    private Date dataNascimento;

    @Getter @Setter
    private String endereco;

    @Getter @Setter
    private String observacao;
}
