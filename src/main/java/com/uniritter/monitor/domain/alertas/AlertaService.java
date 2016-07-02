package com.uniritter.monitor.domain.alertas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uniritter.monitor.domain.metricas.MedicaoService;
import com.uniritter.monitor.domain.metricas.Metrica;
import com.uniritter.monitor.domain.metricas.MetricaService;
import com.uniritter.monitor.domain.regras.RegraService;
import com.uniritter.monitor.domain.tipo.TipoTempo;

@Component
public class AlertaService {

	@Autowired
	MedicaoService medService;

	@Autowired
	RegraService regService;

	public void disparaAlertaUnicoMetrica(Metrica met) {
		Alerta alerta = new Alerta();

		alerta.setMetrica(met);
		alerta.setMedicoes(medService.getMedicaoMaisAtualMetrica(alerta
				.getMetrica().getId()));
		alerta.setRegras(regService.getRegraPorMEtricaID(alerta.getMetrica()
				.getId()));

		for (int i = 0; i < alerta.getRegras().size(); i++) {

			for (int j = 0; j < alerta.getMedicoes().size(); j++) {

				// if
				// (alerta.getMetrica().getTipo().equals(TipoTempo.temperatura))
				// {

				switch (alerta.getMetrica().getTipo()) {
				case temperatura:

					switch (alerta.getRegras().get(i).getNome()) {
					case "maior":
						if (alerta.getMedicoes().get(j).getValor_temp() > alerta
								.getRegras().get(i).getValor()) {

							Notificacao.log(AlertaService.class).info(
									"**** Alerta - Valor da "
											+ TipoTempo.temperatura.toString()
											+ " para medicao ID:"
											+ alerta.getMedicoes().get(j)
													.getId()
											+ " é de:"
											+ alerta.getMedicoes().get(j)
													.getValor_temp()
											+ "(Regra ID:"
											+ alerta.getRegras().get(i).getId()
											+ "valor maior"
											+ alerta.getRegras().get(i)
													.getValor() + ")");
						}
						break;
					case "menor":
						if (alerta.getMedicoes().get(j).getValor_temp() < alerta
								.getRegras().get(i).getValor()) {

							Notificacao.log(AlertaService.class).info(
									"**** Alerta - Valor da "
											+ TipoTempo.temperatura.toString()
											+ " para medicao ID:"
											+ alerta.getMedicoes().get(j)
													.getId()
											+ " eh de:"
											+ alerta.getMedicoes().get(j)
													.getValor_temp()
											+ "(Regra ID:"
											+ alerta.getRegras().get(i).getId()
											+ "valor menor"
											+ alerta.getRegras().get(i)
													.getValor() + ")");
						}
						break;
					}
					break;
				case umidade:
					switch (alerta.getRegras().get(i).getNome()) {
					case "maior":
						if (alerta.getMedicoes().get(j).getValor_umid() > alerta
								.getRegras().get(i).getValor()) {

							Notificacao.log(AlertaService.class).info(
									"**** Alerta - Valor da "
											+ TipoTempo.umidade.toString()
											+ " para medicao ID:"
											+ alerta.getMedicoes().get(j)
													.getId()
											+ " é de:"
											+ alerta.getMedicoes().get(j)
													.getValor_umid()
											+ "(Regra ID:"
											+ alerta.getRegras().get(i).getId()
											+ "valor maior"
											+ alerta.getRegras().get(i)
													.getValor() + ")");
						}
						break;
					case "menor":
						if (alerta.getMedicoes().get(j).getValor_umid() < alerta
								.getRegras().get(i).getValor()) {

							Notificacao.log(AlertaService.class).info(
									"**** Alerta - Valor da "
											+ TipoTempo.umidade.toString()
											+ " para medicao ID:"
											+ alerta.getMedicoes().get(j)
													.getId()
											+ " eh de:"
											+ alerta.getMedicoes().get(j)
													.getValor_umid()
											+ "(Regra ID:"
											+ alerta.getRegras().get(i).getId()
											+ "valor menor"
											+ alerta.getRegras().get(i)
													.getValor() + ")");
						}
						break;

					// }
					/*
					 * 
					 * 
					 * if (alerta.getRegras().get(i).getNome().equals("maior"))
					 * {
					 * 
					 * if (alerta.getMedicoes().get(j).getValor_temp() > alerta
					 * .getRegras().get(i).getValor()) {
					 * 
					 * Notificacao.log(AlertaService.class).info(
					 * "**** Alerta - Valor da " +
					 * TipoTempo.temperatura.toString() + " para medicao ID:" +
					 * alerta.getMedicoes().get(j) .getId() + " é de:" +
					 * alerta.getMedicoes().get(j) .getValor_temp() +
					 * "(Regra ID:" + alerta.getRegras().get(i).getId() +
					 * "valor maior" + alerta.getRegras().get(i) .getValor() +
					 * ")"); }
					 * 
					 * } else { if (alerta.getMedicoes().get(j).getValor_temp()
					 * < alerta .getRegras().get(i).getValor()) {
					 * 
					 * Notificacao.log(AlertaService.class).info(
					 * "**** Alerta - Valor da " +
					 * TipoTempo.temperatura.toString() + " para medicao ID:" +
					 * alerta.getMedicoes().get(j) .getId() + " eh de:" +
					 * alerta.getMedicoes().get(j) .getValor_temp() +
					 * "(Regra ID:" + alerta.getRegras().get(i).getId() +
					 * "valor menor" + alerta.getRegras().get(i) .getValor() +
					 * ")"); }
					 * 
					 * }
					 * 
					 * } else {
					 * 
					 * // Lista alertas para Umidade
					 * 
					 * if (alerta.getRegras().get(i).getNome().equals("maior"))
					 * {
					 * 
					 * if (alerta.getMedicoes().get(j).getValor_umid() > alerta
					 * .getRegras().get(i).getValor()) {
					 * 
					 * Notificacao.log(AlertaService.class).info(
					 * "**** Alerta - Valor da " + TipoTempo.umidade.toString()
					 * + " para medicao ID:" + alerta.getMedicoes().get(j)
					 * .getId() + " eh de:" + alerta.getMedicoes().get(j)
					 * .getValor_umid() + "(Regra ID:" +
					 * alerta.getRegras().get(i).getId() + "valor maior" +
					 * alerta.getRegras().get(i) .getValor() + ")"); }
					 * 
					 * } else { if (alerta.getMedicoes().get(j).getValor_umid()
					 * < alerta .getRegras().get(i).getValor()) {
					 * 
					 * Notificacao.log(AlertaService.class).info(
					 * "**** Alerta - Valor da " + TipoTempo.umidade.toString()
					 * + " para medicao ID:" + alerta.getMedicoes().get(j)
					 * .getId() + " eh de:" + alerta.getMedicoes().get(j)
					 * .getValor_umid() + "(Regra ID:" +
					 * alerta.getRegras().get(i).getId() + "valor menor" +
					 * alerta.getRegras().get(i) .getValor() + ")"); } }
					 */

					}

				}

			}
		}

	}

	public void disparaAlertaMetrica(Metrica met) {

		Alerta alerta = new Alerta();

		alerta.setMetrica(met);
		alerta.setMedicoes(medService.getMedicoesPorMetrica(alerta.getMetrica()
				.getId()));
		alerta.setRegras(regService.getRegraPorMEtricaID(alerta.getMetrica()
				.getId()));

		for (int i = 0; i < alerta.getRegras().size(); i++) {

			for (int j = 0; j < alerta.getMedicoes().size(); j++) {

				if (alerta.getMetrica().getTipo().equals(TipoTempo.temperatura)) {

					if (alerta.getRegras().get(i).getNome().equals("maior")) {

						if (alerta.getMedicoes().get(j).getValor_temp() > alerta
								.getRegras().get(i).getValor()) {

							Notificacao.log(AlertaService.class).info(
									"**** Alerta - Valor da "
											+ TipoTempo.temperatura.toString()
											+ " para medicao ID:"
											+ alerta.getMedicoes().get(j)
													.getId()
											+ " é de:"
											+ alerta.getMedicoes().get(j)
													.getValor_temp()
											+ "(Regra ID:"
											+ alerta.getRegras().get(i).getId()
											+ "valor maior"
											+ alerta.getRegras().get(i)
													.getValor() + ")");
						}

					} else {
						if (alerta.getMedicoes().get(j).getValor_temp() < alerta
								.getRegras().get(i).getValor()) {

							Notificacao.log(AlertaService.class).info(
									"**** Alerta - Valor da "
											+ TipoTempo.temperatura.toString()
											+ " para medicao ID:"
											+ alerta.getMedicoes().get(j)
													.getId()
											+ " eh de:"
											+ alerta.getMedicoes().get(j)
													.getValor_temp()
											+ "(Regra ID:"
											+ alerta.getRegras().get(i).getId()
											+ "valor menor"
											+ alerta.getRegras().get(i)
													.getValor() + ")");
						}

					}

				} else {

					// Lista alertas para Umidade

					if (alerta.getRegras().get(i).getNome().equals("maior")) {

						if (alerta.getMedicoes().get(j).getValor_umid() > alerta
								.getRegras().get(i).getValor()) {

							Notificacao.log(AlertaService.class).info(
									"**** Alerta - Valor da "
											+ TipoTempo.umidade.toString()
											+ " para medicao ID:"
											+ alerta.getMedicoes().get(j)
													.getId()
											+ " eh de:"
											+ alerta.getMedicoes().get(j)
													.getValor_umid()
											+ "(Regra ID:"
											+ alerta.getRegras().get(i).getId()
											+ "valor maior"
											+ alerta.getRegras().get(i)
													.getValor() + ")");
						}

					} else {
						if (alerta.getMedicoes().get(j).getValor_umid() < alerta
								.getRegras().get(i).getValor()) {

							Notificacao.log(AlertaService.class).info(
									"**** Alerta - Valor da "
											+ TipoTempo.umidade.toString()
											+ " para medicao ID:"
											+ alerta.getMedicoes().get(j)
													.getId()
											+ " eh de:"
											+ alerta.getMedicoes().get(j)
													.getValor_umid()
											+ "(Regra ID:"
											+ alerta.getRegras().get(i).getId()
											+ "valor menor"
											+ alerta.getRegras().get(i)
													.getValor() + ")");
						}
					}

				}

			}

		}

	}

}
