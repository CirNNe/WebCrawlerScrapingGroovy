package WebCrawler_Scraping

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class CrawlerComponentesComunicacao extends GenericWebCrawlerScraping{

    boolean baixaArquivoComponentesComunicacao() {

        try {

            Document documentPagPadraoTiss = super.retornaDOMPagPadraoTiss()

            Element tabelaUrlPadraoTiss = documentPagPadraoTiss.getElementsByClass("table table-bordered").last()

            Element procuraLinkComponenteComunicacao = tabelaUrlPadraoTiss.select("a[href]").last()

            String linkComponenteComunicacao = procuraLinkComponenteComunicacao.attr("href")

            String diretorioDownloadArquivos = "./Downloads/ComponentesComunicacao.zip"

            def baixaArquivo = super.baixaArquivo(linkComponenteComunicacao, diretorioDownloadArquivos)

            return true

        } catch (Exception e) {
            e.printStackTrace()
            return false
        }
    }
}
