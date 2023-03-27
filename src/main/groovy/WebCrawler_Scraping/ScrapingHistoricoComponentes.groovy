package WebCrawler_Scraping

import Models.DAO.VersoesComponentesDAO
import Models.Entidades.VersoesDosComponentesPadraoTiss
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

class ScrapingHistoricoComponentes extends GenericWebCrawlerScraping {

    VersoesComponentesDAO versoesComponentesDAO = new VersoesComponentesDAO()

    boolean insereDadosTabelaHistoricoComponentes() {

        Document documentPagHistoricoVersoesComponentes = super.retornaDOMPagHistoricoVersoesComponentes()

        Element divHistoricoVersoesComponentesPadraoTiss = documentPagHistoricoVersoesComponentes.getElementById("parent-fieldname-text")

        Elements elementosTabelaHistorico = divHistoricoVersoesComponentesPadraoTiss.getElementsByTag("tr")

        for(int posicao = elementosTabelaHistorico.size() - 1; posicao >= 36; posicao--) {
            elementosTabelaHistorico.remove(posicao)
        }

        elementosTabelaHistorico.remove(0)

        List<VersoesDosComponentesPadraoTiss> tabelaHistoricoVersoesComponentesPadraoTiss = new ArrayList()

        elementosTabelaHistorico.forEach {elementos ->
            String competencia = elementos.getElementsByTag("td").get(0).html()
            String publicacao = elementos.getElementsByTag("td").get(1).html()
            String inicioVirgencia = elementos.getElementsByTag("td").get(2).html()
            VersoesDosComponentesPadraoTiss versoesDosComponentesPadraoTiss = new VersoesDosComponentesPadraoTiss(competencia, publicacao, inicioVirgencia)
            tabelaHistoricoVersoesComponentesPadraoTiss.add(versoesDosComponentesPadraoTiss)
        }

        for(int posicao = 0; posicao < tabelaHistoricoVersoesComponentesPadraoTiss.size(); posicao++) {

            if(versoesComponentesDAO.confereDadosDaTabelaVersoesComponentes(tabelaHistoricoVersoesComponentesPadraoTiss[posicao] as VersoesDosComponentesPadraoTiss)) {
                versoesComponentesDAO.inserirDadosNaTabelaVersoesComponentes(tabelaHistoricoVersoesComponentesPadraoTiss[posicao] as VersoesDosComponentesPadraoTiss)
                println("inserido: " + tabelaHistoricoVersoesComponentesPadraoTiss[posicao])
            }
        }
        return true
    }
}
