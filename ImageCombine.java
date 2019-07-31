// Java Program to compare two images
import java.awt.image.BufferedImage;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths; 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

class ImageCombine
{
    public static void main(String[] args)
    {
        BufferedImage imgA = null;
        BufferedImage imgB = null;
        int num1=1;
        int num2=2;	

        int startnum=Integer.parseInt(args[0]);
        //int total = Integer.parseInt(args[1]);
        int total =0;

           System.out.println("startnum:total" + startnum+":"+total);

	   //rename files
	 File folder = new File("downloaded");
        File[] listOfFiles = folder.listFiles();
        int num=startnum;
        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

		//String ext1 = FilenameUtils.getExtension("downloaded/"+listOfFiles[i]);
		//
		File f = new File("downloaded/"+listOfFiles[i].getName()); 
		String ext1 = getFileExtension(f);
		   System.out.println("extns:i" + ext1+":"+i);

		if(ext1.equals("png")) {
			//File f = new File("downloaded/"+listOfFiles[i].getName()); 
		   System.out.println("num:i" + num+":"+i);
			f.renameTo(new File("renamed/pic"+num+".png"));
			num++;
			total++;
		}
		else if (ext1.equals("jpg")){
			//File f = new File("downloaded/"+listOfFiles[i].getName()); 
			f.renameTo(new File("renamed/pic"+num+".jpg"));
			num++;
			total++;

		}
            }
        }


    for (int imgnum=startnum;imgnum<startnum+total;imgnum++) {
        try
        {
            
            File fileAjpg = new File( "renamed/pic"+imgnum+".jpg");
            //File fileB = new File("rawpic/pic"+imgnum+".jpg");
		if(fileAjpg.exists() && !fileAjpg.isDirectory()) {  
		    imgA = ImageIO.read(fileAjpg);
		}
		else {
		    File fileApng = new File( "renamed/pic"+imgnum+".png");
			if(fileApng.exists() && !fileApng.isDirectory()) {  
			    imgA = ImageIO.read(fileApng);
			}
		}
            //imgB = ImageIO.read(fileB);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }


        int width1 = imgA.getWidth();
        //int width2 = imgB.getWidth();
        int height1 = imgA.getHeight();
        //int height2 = imgB.getHeight();
	int offsetatMiddle = 6;
	int finht = height1*2+offsetatMiddle;
	int offsetatBottom=finht/10;

        System.out.println("offset for imag" + offsetatBottom+":"+finht);
         
	finht = finht+offsetatBottom;

	final int[] p1 = imgA.getRGB(0, 0, width1, height1, null, 0, width1);
	int p3size = (2*p1.length + offsetatBottom*width1 + offsetatMiddle*width1);
	final int[] p3 = new int[p3size]  ;


	    for (int i = 0; i < p1.length; i++) {
                 p3[i] = p1[i];
		 p3[p1.length+i+offsetatMiddle*width1]=p1[i];
            }

	    //fill middle
	    for (int k=0;k<offsetatMiddle*width1;k++) {
               p3[p1.length+k]=Color.RED.getRGB();
	    }

	    //fill bottom
	    for (int j=0;j<offsetatBottom*width1;j++) {
               p3[2*p1.length+j]=Color.WHITE.getRGB();
	    }


        try
        {
	    final BufferedImage out = new BufferedImage(width1, finht, BufferedImage.TYPE_INT_RGB);
    out.setRGB(0, 0, width1, finht, p3, 0, width1);

		File outputfile = new File("combined/pic"+imgnum+".jpg");
		ImageIO.write(out, "jpg", outputfile);
 
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
 







			 //   int imageht = height1-150;//remove lower border
			 //   int finimageht = imageht-10;//remove middle border

			 //   int eachimght= finimageht/2;//half size

        
    } 
}
private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

}
