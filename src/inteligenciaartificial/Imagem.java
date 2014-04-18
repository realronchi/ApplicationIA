package inteligenciaartificial;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

public class Imagem {
    
    public byte[][] converter(String aluno, String imagem, String tipo) throws IOException {
        String urlImagem = "C:\\Users\\Fabrício Ronchi\\Desktop\\InteligenciaArtificial\\imagens\\" + aluno + "_" + imagem + "_" + tipo + ".bmp";
        BufferedImage image = ImageIO.read(new File(urlImagem));
        byte[][] pixels = new byte[image.getWidth()][];

        for (int x = 0; x < image.getWidth(); x++) {
            pixels[x] = new byte[image.getHeight()];
            for (int y = 0; y < image.getHeight(); y++) {
                pixels[x][y] = (byte) (image.getRGB(x, y) == 0xFFFFFFFF ? 0 : 1);
            }
        }
        return pixels;    
    }
    
    public void criarCabecalho(String patterns, String inputs, String outputs) throws IOException {                
        FileWriter arq = new FileWriter("C:\\Users\\Fabrício Ronchi\\Desktop\\InteligenciaArtificial\\numeros.pat");
        PrintWriter gravarArq = new PrintWriter(arq);                        
        String cabecalho = 
                "SNNS pattern definition file V3.2" +
                "\n" + 
                "generated at Mon Apr 25 15:58:23 1994" + 
                "\n" + 
                "\n" + 
                "No. of patterns: " + patterns +
                "\n" + 
                "No. of input units: " + inputs +
                "\n" + 
                "No. of output units: " + outputs +
                "\n" + 
                "\n" + 
                "\n";
        gravarArq.printf(cabecalho);                
        arq.close();                                               
    };
    
    public void imprimir(byte[][] imagem, String aluno, String caracter, String tipo) throws IOException {                                 
        FileWriter arq = new FileWriter("C:\\Users\\Fabrício Ronchi\\Desktop\\InteligenciaArtificial\\numeros.pat", true);
        PrintWriter gravarArq = new PrintWriter(arq);        
        for (int i = 0; i < imagem.length; i++) {                        
            for (int j = 0; j < imagem[i].length; j++) {                                                     
                gravarArq.printf(imagem[j][i] + " ");                
            }                      
            gravarArq.printf("\n");
        }
        gravarArq.printf("\n");
        gravarArq.printf("\n");
        arq.close();                                               
    }    
}
