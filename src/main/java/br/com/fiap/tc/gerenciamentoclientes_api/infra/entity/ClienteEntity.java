package br.com.fiap.tc.gerenciamentoclientes_api.infra.entity;


import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clienteId;
    @NonNull
    private String nome;
    @NonNull
    private String email;
    @NonNull
    private String telefone;
    @NonNull
    private String logradouro;
    @NonNull
    private String bairro;
    @NonNull
    private String cep;
    private String complemento;
    @NonNull
    private String numero;
    @NonNull
    private String uf;
    @NonNull
    private String cidade;


}
