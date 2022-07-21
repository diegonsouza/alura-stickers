package stickers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {

    public String cria(InputStream inputStream, String nomeArquivo) throws Exception {

        // leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        // criar nova imagem em memoria com transparência e com tamanho novo
        String dadosImagem = "Width: " + Integer.toString(imagemOriginal.getWidth()) + " - Height: "
                + Integer.toString(imagemOriginal.getHeight());
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        // copiar a imagem origianl para nova imagem (em memória)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        // configurar a fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
        graphics.setColor(Color.YELLOW);
        graphics.setFont(fonte);

        // escrever uma frase na nova imagem
        graphics.drawString("ESSE É TOP!", 200, novaAltura - 100);

        // escrever a nova imagem em um arquivo
        nomeArquivo = formataNomeDoArquivo(nomeArquivo);
        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

        return dadosImagem;

    }

    private String formataNomeDoArquivo(String nomeArquivo) {
        nomeArquivo = nomeArquivo.replaceAll(":", " -");
        return nomeArquivo;

    }
}
