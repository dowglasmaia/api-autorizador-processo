package org.maia.procedimentosapi.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.maia.procedimentosapi.domain.enums.Sexo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Audited
@AuditTable(value = "procedimento_audit")
@Table
@Entity
public class Procedimento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "numero_procedimento", nullable = false, unique = true, updatable = false)
	@NotNull(message = "informe o número do procedimento para prosseguir com a operação.")	
	private Integer numProcedimento;	

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Sexos")
	private Set<Integer> sexos = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name = "IDADES")
	private Set<Integer> idades = new HashSet<>();

	public Procedimento(Long id, Integer numProcedimento) {
		super();
		this.id = id;
		this.numProcedimento = numProcedimento;
		
	}

	public Set<Sexo> getSexos() {
		return sexos.stream().map(s -> Sexo.toEnum(s)).collect(Collectors.toSet());
	}

	public void addSexo(Sexo sexo) {
		sexos.add(sexo.getCod());
	}

}
