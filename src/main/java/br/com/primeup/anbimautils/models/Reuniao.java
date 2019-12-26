package br.com.primeup.anbimautils.models;

import java.time.LocalDate;
import java.time.LocalTime;

import br.com.primeup.anbimautils.enums.LocalReuniao;
import br.com.primeup.anbimautils.enums.RespostaBinaria;
import br.com.primeup.anbimautils.enums.TipoReuniao;

public class Reuniao {
	private TipoReuniao tipo;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaTermino;
	private String assunto;
	private LocalReuniao local;
	private String outroLocal;
	private String textoInvite;
	private RespostaBinaria contabilizacaoDeFalta;

	public Reuniao(TipoReuniao tipo, LocalDate data, LocalTime horaInicio, LocalTime horaTermino, String assunto,
			LocalReuniao local, String outroLocal, String textoInvite, RespostaBinaria contabilizacaoDeFalta) {
		super();
		this.tipo = tipo;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.assunto = assunto;
		this.local = local;
		this.outroLocal = outroLocal;
		this.textoInvite = textoInvite;
		this.contabilizacaoDeFalta = contabilizacaoDeFalta;
	}

	public TipoReuniao getTipo() {
		return tipo;
	}

	public LocalDate getData() {
		return data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraTermino() {
		return horaTermino;
	}

	public String getAssunto() {
		return assunto;
	}

	public LocalReuniao getLocal() {
		return local;
	}

	public String getOutroLocal() {
		return outroLocal;
	}

	public String getTextoInvite() {
		return textoInvite;
	}

	public RespostaBinaria getContabilizacaoDeFalta() {
		return contabilizacaoDeFalta;
	}

}
