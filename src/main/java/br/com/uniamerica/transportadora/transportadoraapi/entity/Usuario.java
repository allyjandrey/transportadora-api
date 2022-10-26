package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "tb_usuarios", schema = "transportadora")
public class Usuario extends AbstractEntity {

    @Getter @Setter
    @Column(name = "perc_ganho", nullable = false, precision = 5, scale = 3)
    private BigDecimal percGanho;

    @Getter @Setter
    @Column(name = "login", length = 25, nullable = false, unique = true)
    private String login;


    @Getter @Setter
    @Column(name = "senha", length = 15, nullable = false)
    private String senha;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "grupo", length = 15, nullable = false)
    private Grupo grupo;

    @Getter @Setter
    @Column(name = "nome", length = 20, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "cpf", length = 11, nullable = false, unique = true)
    private String cpf;

    @Getter @Setter
    @Column(name = "telefone", length = 19 , nullable = false, unique = true)
    private int telefone;

    @Getter @Setter
    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Getter @Setter
    @Column(name = "endereco", length = 20, nullable = false)
    private String endereco;

    @Getter @Setter
    @Column(name = "observacao")
    private String observacao;
}
