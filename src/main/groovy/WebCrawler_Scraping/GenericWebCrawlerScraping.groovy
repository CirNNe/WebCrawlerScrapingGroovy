package WebCrawler_Scraping

import groovyx.net.http.HttpBuilder
import org.apache.commons.io.IOUtils
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class GenericWebCrawlerScraping {

    Document retornaDOMSiteAns() {
        HttpBuilder requestUrlPrincipal = HttpBuilder.configure {
            request.uri = 'https://www.gov.br/ans/pt-br'
        }

        Object responseUrlPrincipal = requestUrlPrincipal.get()

        Document documentUrlPrincipal = Jsoup.parse(responseUrlPrincipal.toString())

        return documentUrlPrincipal
    }

    Document retornaDOMPagEspacoPrestadorServico() {

        Document documentPagSiteAns = retornaDOMSiteAns()

        Element divUrlPrincipal = documentPagSiteAns.getElementById("ce89116a-3e62-47ac-9325-ebec8ea95473")

        Element procuraLinkEspacoPrestadorServicosSaude = divUrlPrincipal.select("a[href]").first()

        String linkEspacoPrestadorServicoSaude = procuraLinkEspacoPrestadorServicosSaude.attr('href')

        HttpBuilder requestUrlEspacoPrestadorServicosSaude = HttpBuilder.configure {
            request.uri = linkEspacoPrestadorServicoSaude
        }

        Object responseUrlEspacoPrestadorServicosSaude = requestUrlEspacoPrestadorServicosSaude.get()

        Document documentEspacoPrestadorServicosSaude = Jsoup.parse(responseUrlEspacoPrestadorServicosSaude.toString())

        return documentEspacoPrestadorServicosSaude
    }

    Document retornaDOMPagTissPadraoTrocaInformacoesSaudeComplementar() {

        Document documentPagEspacoPrestadorServico = retornaDOMPagEspacoPrestadorServico()

        Element divUrlEspacoPrestadorServicosSaude = documentPagEspacoPrestadorServico.getElementById("content-core")

        Element procuraLinkTissPadraoTrocaInformacoesSaudeComplementar = divUrlEspacoPrestadorServicosSaude.select("a[href]").first()

        String linkTissPadraoTrocaInformacoesSaudeComplementar = procuraLinkTissPadraoTrocaInformacoesSaudeComplementar.attr("href")

        HttpBuilder requestUrlTissPadraoTrocaInformacoesSaudeComplementar = HttpBuilder.configure {
            request.uri = linkTissPadraoTrocaInformacoesSaudeComplementar
        }

        Object responseUrlTissPadraoTrocaInformacoesSaudeComplementar = requestUrlTissPadraoTrocaInformacoesSaudeComplementar.get()

        Document documentTissPadraoTrocaInformacoesSaudeComplementar = Jsoup.parse(responseUrlTissPadraoTrocaInformacoesSaudeComplementar.toString())

        return documentTissPadraoTrocaInformacoesSaudeComplementar

    }

    Document retornaDOMPagPadraoTiss() {

        Document documentPagTissPadraoTrocaInformacoesSaudeComplementar = retornaDOMPagTissPadraoTrocaInformacoesSaudeComplementar()

        Element divUrlPadraoTiss = documentPagTissPadraoTrocaInformacoesSaudeComplementar.getElementById("parent-fieldname-text")

        Element procuraLinkPadraoTiss = divUrlPadraoTiss.select("a[href]").first()

        String linkPadraoTiss = procuraLinkPadraoTiss.attr("href")

        HttpBuilder resquestUrlPadraoTiss = HttpBuilder.configure {
            request.uri = linkPadraoTiss
        }

        Object responseUrlPadraoTiss = resquestUrlPadraoTiss.get()

        Document documentPadraoTiss = Jsoup.parse(responseUrlPadraoTiss.toString())

        return documentPadraoTiss

    }

    Document retornaDOMPagHistoricoVersoesComponentes() {

        Document documentPagTissPadraoTrocaInformacoesSaudeComplementar = retornaDOMPagTissPadraoTrocaInformacoesSaudeComplementar()

        Element divContemLinkHistoricoVersoesComponentes = documentPagTissPadraoTrocaInformacoesSaudeComplementar.getElementById("parent-fieldname-text")

        Element procuraLinkHistoricoVersoesComponentes = divContemLinkHistoricoVersoesComponentes.select("a[href]")[1]

        String linkHistoricoVersoesComponentes = procuraLinkHistoricoVersoesComponentes.attr("href")

        HttpBuilder requestHistoricoVersoesComponentes = HttpBuilder.configure {
            request.uri = linkHistoricoVersoesComponentes
        }

        Object responseHistoricoVersoesComponentes = requestHistoricoVersoesComponentes.get()

        Document documentHistoricoVersoesComponentes = Jsoup.parse(responseHistoricoVersoesComponentes.toString())

        return documentHistoricoVersoesComponentes
    }

    Document retornaDOMPagTabelasRelacionais() {

        Document documentPagTissPadraoTrocaInformacoesSaudeComplementar = retornaDOMPagTissPadraoTrocaInformacoesSaudeComplementar()

        Element divContemLinkHistoricoVersoesComponentes = documentPagTissPadraoTrocaInformacoesSaudeComplementar.getElementById("parent-fieldname-text")

        Element procuraLinkPagTabelasRelacionais = divContemLinkHistoricoVersoesComponentes.select("a[href]")[2]

        String linkPagTabelasRelacionais = procuraLinkPagTabelasRelacionais.attr("href")

        HttpBuilder requestTabelasRelacionadas = HttpBuilder.configure {
            request.uri = linkPagTabelasRelacionais
        }

        Object responseTabelasRelacionadas = requestTabelasRelacionadas.get()

        Document documentTabelasRelacionadas = Jsoup.parse(responseTabelasRelacionadas.toString())

        return documentTabelasRelacionadas

    }

    boolean baixaArquivo(String linkDoArquivo, String diretorioDownload) {
        try {
            URL url = new URL(linkDoArquivo)
            IOUtils.copy(url.openStream(), new FileOutputStream(diretorioDownload))
            println("Arquivo baixado com sucesso em: " + diretorioDownload)
            return true
        } catch(IOException | IllegalArgumentException e) {
            e.printStackTrace()
            return false
        }
    }
}
