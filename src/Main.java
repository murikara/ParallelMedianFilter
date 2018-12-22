import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Arrays;
import javax.imageio.*;

/**
 * De main class bevat de Median Filter algoritme die een afbeelding inlaadt, verwerkt en vervolgens de
 * verwerkte afbeelding als output geeft
 */
public class Main {

    public static void main(String[] args) throws Throwable {
        //het aantal pixels die het algoritme in een handeling verwerkt. Dit is inclusief de "doelpixel"
        int window = 9;
        File f=new File("C:/Users/marat/Pictures/outputSmall.jpg");
        Color[] pixel=new Color[window];
        int[] R=new int[window];
        int[] B=new int[window];
        int[] G=new int[window];
        File output=new File("C:/Users/marat/Pictures/output.jpg");
        BufferedImage img=ImageIO.read(f);
        for(int i=1;i<img.getWidth()-1;i++)
            for(int j=1;j<img.getHeight()-1;j++)
            {
                pixel[0]=new Color(img.getRGB(i-1,j-1));
                pixel[1]=new Color(img.getRGB(i-1,j));
                pixel[2]=new Color(img.getRGB(i-1,j+1));
                pixel[3]=new Color(img.getRGB(i,j+1));
                pixel[4]=new Color(img.getRGB(i+1,j+1));
                pixel[5]=new Color(img.getRGB(i+1,j));
                pixel[6]=new Color(img.getRGB(i+1,j-1));
                pixel[7]=new Color(img.getRGB(i,j-1));
                pixel[8]=new Color(img.getRGB(i,j));
                for(int k=0;k<9;k++){
                    R[k]=pixel[k].getRed();
                    B[k]=pixel[k].getBlue();
                    G[k]=pixel[k].getGreen();
                }
                Arrays.sort(R);
                Arrays.sort(G);
                Arrays.sort(B);
                img.setRGB(i,j,new Color(R[4],B[4],G[4]).getRGB());
            }
        ImageIO.write(img,"jpg",output);

    }
}
