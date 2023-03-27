package WebCrawler_Scraping

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class CrawlerTabelaErrosEnvioAns extends GenericWebCrawlerScraping {

    boolean baixaArquivoTabelaErrosEnvioAns() {

        Document linkPagTabelasRelacionais = super.retornaDOMPagTabelasRelacionais()

        Element divTabelasRelacionadas = linkPagTabelasRelacionais.getElementById("parent-fieldname-text")

        Element procuraLinkArquivoTabelaErrosEnvioAns = divTabelasRelacionadas.select("a[href]").first()

        String linkArquivoTabelaErrosEnvioAns = procuraLinkArquivoTabelaErrosEnvioAns.attr("href")

        String diretorioArquivoTabelaErrosEnvioAns = "./Downloads/Tabela_Erros_Envio_Ans.xlsx"

        def baixaArquivoTabelaErrosEnvioAns = baixaArquivo(linkArquivoTabelaErrosEnvioAns, diretorioArquivoTabelaErrosEnvioAns)

        return true

    }
}
