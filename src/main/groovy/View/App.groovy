package View

import Models.DAO.VersoesComponentesDAO
import WebCrawler_Scraping.CrawlerComponentesComunicacao
import WebCrawler_Scraping.CrawlerTabelaErrosEnvioAns
import WebCrawler_Scraping.ScrapingHistoricoComponentes

CrawlerComponentesComunicacao crawlerComponentesComunicacao = new CrawlerComponentesComunicacao()
ScrapingHistoricoComponentes scrapingHistoricoComponentes = new ScrapingHistoricoComponentes()
CrawlerTabelaErrosEnvioAns crawlerTabelaErrosEnvioAns = new CrawlerTabelaErrosEnvioAns()
VersoesComponentesDAO versoesComponentesDAO = new VersoesComponentesDAO()

Scanner inputOpcaoUsuario = new Scanner(System.in)
int opcaoUsuario = 3
while(opcaoUsuario != 0) {

    println("----- MENU USUÁRIO -----\n" +
            "1 - BAIXAR ARQUIVO .zip COMPONENTE DE COMUNICAÇÃO\n" +
            "2 - LER HISTÓRICO DAS VERSÕES DOS COMPONENTES DO PADRÃO TISS\n"+
            "3 - BAIXAR ARQUIVO .xlsx TABELA DE ERROS NO ENVIO PARA A ANS \n" +
            "0 - SAIR")

    opcaoUsuario = inputOpcaoUsuario.nextInt()

    if(opcaoUsuario == 1) {

        crawlerComponentesComunicacao.baixaArquivoComponentesComunicacao()

    } else if(opcaoUsuario == 2) {

        scrapingHistoricoComponentes.insereDadosTabelaHistoricoComponentes()
        versoesComponentesDAO.leDadosTabelaVersoesComponentes()

    } else if(opcaoUsuario == 3) {

        crawlerTabelaErrosEnvioAns.baixaArquivoTabelaErrosEnvioAns()

    } else if(opcaoUsuario == 0) {
        break
    }
}
