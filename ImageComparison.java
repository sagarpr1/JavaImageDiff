// Java Program to compare two images
import java.awt.image.BufferedImage;
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


class ImageComparison
{
    public static void main(String[] args)
    {
        BufferedImage imgA = null;
        BufferedImage imgB = null;
        int num1=1;
        int num2=2;
        int range=100;	


        int startnum=Integer.parseInt(args[0]);
        int total = Integer.parseInt(args[1]);

            System.out.println("startnum:total" + startnum+":"+total);

    for (int imgnum=startnum;imgnum<startnum+total;imgnum++) {
        try
        {

            File fileA = new File( "wdiff/pic"+ imgnum+".jpg");
            File fileB = new File("wodiff/pic"+imgnum+".jpg");
 
            imgA = ImageIO.read(fileA);
            imgB = ImageIO.read(fileB);
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        int width1 = imgA.getWidth();
        int width2 = imgB.getWidth();
        int height1 = imgA.getHeight();
        int height2 = imgB.getHeight();

	int firstx=0;
	int firsty=0;
	int firsttime=0;
	int firstavgx=0;
	int firstavgy=0;
	int numpt1=0;

	int secondx=0;
	int secondy=0;
	int secondtime=0;
	int secondavgx=0;
	int secondavgy=0;
	int numpt2=0;

	int thirdx=0;
	int thirdy=0;
	int thirdtime=0;
	int thirdavgx=0;
	int thirdavgy=0;
	int numpt3=0;

	int fourthx=0;
	int fourthy=0;
	int fourthtime=0;
	int fourthavgx=0;
	int fourthavgy=0;
	int numpt4=0;

	int fifthx=0;
	int fifthy=0;
	int fifthtime=0;
	int fifthavgx=0;
	int fifthavgy=0;
	int numpt5=0;

	int sixthx=0;
	int sixthy=0;
	int sixthtime=0;
	int sixthavgx=0;
	int sixthavgy=0;
	int numpt6=0;

        if ((width1 != width2) || (height1 != height2))
            System.out.println("Error: Images dimensions"+
                                             " mismatch");
        else
        {
            long difference = 0;
            for (int y = 0; y < height1; y++)
            {
                for (int x = 0; x < width1; x++)
                {
                    int rgbA = imgA.getRGB(x, y);
                    int rgbB = imgB.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA) & 0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB) & 0xff;

		    difference = 0;
                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);

		    if ((difference > 20) || (difference < -20)) {


				int coordx1diff = x -firstx;
				int coordy1diff = y -firsty;
				int coordx2diff = x -secondx;
				int coordy2diff = y -secondy;
				int coordx3diff = x -thirdx;
				int coordy3diff = y -thirdy;
				int coordx4diff = x -fourthx;
				int coordy4diff = y -fourthy;
				int coordx5diff = x -fifthx;
				int coordy5diff = y -fifthy;
				int coordx6diff = x -sixthx;
				int coordy6diff = y -sixthy;

			    if (firsttime == 0) {
				    // if this is first diff store coord
				    firstx=x;
				    firsty=y;
				  firstavgx +=x;
				  firstavgy +=y;	  
				    firsttime = 1;
				    numpt1++;
			    }
			    else if((coordx1diff <range && coordx1diff>-range) && (coordy1diff<range && coordy1diff>-range)) {
				  firstavgx +=x;
				  firstavgy +=y;	  
				    numpt1++;
			     }
		             else if (secondtime ==0) {
					    secondx=x;
					    secondy=y;
					  secondavgx +=x;
					  secondavgy +=y;	  
					    secondtime = 1;
					    numpt2++;

			    }	   
			    else if((coordx2diff <range && coordx2diff>-range) && (coordy2diff<range && coordy2diff>-range)) {
					  secondavgx +=x;
					  secondavgy +=y;	  
					    numpt2++;
		             }
		             else if (thirdtime ==0) {
					    thirdx=x;
					    thirdy=y;
					  thirdavgx +=x;
					  thirdavgy +=y;	  
					    thirdtime = 1;
					    numpt3++;

			      }	   
			    else if((coordx3diff <range && coordx3diff>-range) && (coordy3diff<range && coordy3diff>-range)) {
					  thirdavgx +=x;
					  thirdavgy +=y;	  
					    numpt3++;
			      }
			    else if (fourthtime ==0) {
					  fourthx=x;
					  fourthy=y;
					  fourthavgx +=x;
					  fourthavgy +=y;	  
					  fourthtime = 1;
					   numpt4++;



			    }	
			    else if((coordx4diff <range && coordx4diff>-range) && (coordy4diff<range && coordy4diff>-range)) {
					  fourthavgx +=x;
					  fourthavgy +=y;	  
					    numpt4++;
			      }
			    else if (fifthtime ==0) {
					  fifthx=x;
					  fifthy=y;
					  fifthavgx +=x;
					  fifthavgy +=y;	  
					  fifthtime = 1;
					   numpt5++;



			    }	
			    else if((coordx5diff <range && coordx5diff>-range) && (coordy5diff<range && coordy5diff>-range)) {
					  fifthavgx +=x;
					  fifthavgy +=y;	  
					    numpt5++;
			      }
			    else if (sixthtime ==0) {
					  sixthx=x;
					  sixthy=y;
					  sixthavgx +=x;
					  sixthavgy +=y;	  
					  sixthtime = 1;
					   numpt6++;



			    }	
			    else if((coordx6diff <range && coordx6diff>-range) && (coordy6diff<range && coordy6diff>-range)) {
					  sixthavgx +=x;
					  sixthavgy +=y;	  
					    numpt6++;
			      }

			    }
			    //System.out.println("x:y diff is" + x +":" + y + " Diff:" + difference);
		    }
                }
            }

	    int xavg1 =0;
	   int yavg1=0;
	    int xavg2 =0;
	   int yavg2=0;
	    int xavg3 =0;
	   int yavg3=0;
	    int xavg4 =0;
	   int yavg4=0;
	    int xavg5 =0;
	   int yavg5=0;
	    int xavg6 =0;
	   int yavg6=0;


	  if (numpt1 !=0) {
	   xavg1= firstavgx/numpt1;
	   yavg1 = firstavgy/numpt1;
	  }
	  if (numpt1 !=0) {
	   xavg1= firstavgx/numpt1;
	   yavg1 = firstavgy/numpt1;
	  }
	  if (numpt2 !=0) {
	   xavg2= secondavgx/numpt2;
	   yavg2 = secondavgy/numpt2;
	  }
	  if (numpt3 !=0) {
	   xavg3= thirdavgx/numpt3;
	   yavg3 = thirdavgy/numpt3;
	  }
	  if (numpt4 !=0) {
	   xavg4= fourthavgx/numpt4;
	   yavg4 = fourthavgy/numpt4;
	  }
	  if (numpt5 !=0) {
	   xavg5= fifthavgx/numpt5;
	   yavg5 = fifthavgy/numpt5;
	  }
	  if (numpt6 !=0) {
	   xavg6= sixthavgx/numpt6;
	   yavg6 = sixthavgy/numpt6;
	  }

			    System.out.println("x:y diff is" + xavg1 +":" + yavg1 );
			    System.out.println("x:y diff is" + xavg2 +":" + yavg2 );
			    System.out.println("x:y diff is" + xavg3 +":" + yavg3 );
			    System.out.println("x:y diff is" + xavg4 +":" + yavg4 );
			    System.out.println("x:y diff is" + xavg5 +":" + yavg5 );



			    int imageht = height1-150;//remove lower border
			    int finimageht = imageht-10;//remove middle border

			    int eachimght= finimageht/2;//half size

			    eachimght = (45 *height1)/100 +3;//0.45 is half wo lower border(10%), 3 is because 6px is in middle

			    int y11 = yavg1 + eachimght;
			    int y21 = yavg2 + eachimght;
			    int y31 = yavg3 + eachimght;
			    int y41 = yavg4 + eachimght;
			    int y51 = yavg5 + eachimght;
			    int y61 = yavg6 + eachimght;

			    //write out
			    //
			    //
			     try {
            //Whatever the file path is.
            File statText = new File("arr.xml");
            FileOutputStream is = new FileOutputStream(statText,true);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer writer = new BufferedWriter(osw);
	    writer.write("<integer-array name=\"arraypic"+imgnum+"\">\n");
	    writer.write("<item>"+width2+"</item>\n");
	    writer.write("<item>"+height2+"</item>\n\n");
	    writer.write("<item>"+xavg1+"</item>\n");
	    writer.write("<item>"+yavg1+"</item>\n");
	    writer.write("<item>"+xavg2+"</item>\n");
	    writer.write("<item>"+yavg2+"</item>\n");
	    writer.write("<item>"+xavg3+"</item>\n");
	    writer.write("<item>"+yavg3+"</item>\n");
	    writer.write("<item>"+xavg4+"</item>\n");
	    writer.write("<item>"+yavg4+"</item>\n");
	    writer.write("<item>"+xavg5+"</item>\n");
	    writer.write("<item>"+yavg5+"</item>\n\n");
            if (xavg6 !=0) {
		    writer.write("<item>"+xavg6+"</item>\n");
		    writer.write("<item>"+yavg6+"</item>\n\n");
	    }


	    writer.write("<item>"+xavg1+"</item>\n");
	    writer.write("<item>"+y11+"</item>\n");
	    writer.write("<item>"+xavg2+"</item>\n");
	    writer.write("<item>"+y21+"</item>\n");
	    writer.write("<item>"+xavg3+"</item>\n");
	    writer.write("<item>"+y31+"</item>\n");
	    writer.write("<item>"+xavg4+"</item>\n");
	    writer.write("<item>"+y41+"</item>\n");
	    writer.write("<item>"+xavg5+"</item>\n");
	    writer.write("<item>"+y51+"</item>\n");
	    if (xavg6 !=0) {
		    writer.write("<item>"+xavg6+"</item>\n");
		    writer.write("<item>"+y61+"</item>\n");
	    }
	    writer.write("</integer-array>\n\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
			   // BufferedWriter output = null;
	//		    try (Writer writer = new BufferedWriter(new OutputStreamWriter(
          //    new FileOutputStream("arrays.xml"), "utf-8"))) {
   // writer.write("<integer-array name=\"arraypic"+num1+"\">");
   // writer.write("<item>"+xavg1+"</item>");
//}
 
            // Total number of red pixels = width * height
            // Total number of blue pixels = width * height
            // Total number of green pixels = width * height
            // So total number of pixels = width * height * 3
        
    } 

    //write other to xml file
    for (int imgnum1=startnum;imgnum1<startnum+total;imgnum1++) {
			     try {
            //Whatever the file path is.
            File statText = new File("arr.xml");
            FileOutputStream is = new FileOutputStream(statText,true);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer writer = new BufferedWriter(osw);
	    writer.write("<item>@drawable/pic"+imgnum1+"</item>\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }

    }
    //write other to xml file
    for (int imgnum2=startnum;imgnum2<startnum+total;imgnum2++) {
			     try {
            //Whatever the file path is.
            File statText = new File("arr.xml");
            FileOutputStream is = new FileOutputStream(statText,true);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer writer = new BufferedWriter(osw);
	    writer.write("<item>@array/arraypic"+imgnum2+"</item>\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }
    //write other to xml file
    for (int imgnum3=startnum;imgnum3<startnum+total;imgnum3++) {
			     try {
            //Whatever the file path is.
            File statText = new File("MainFileOp.txt");
            FileOutputStream is = new FileOutputStream(statText,true);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer writer = new BufferedWriter(osw);
	    writer.write("public void spot"+imgnum3+"(View view) {\n");
	    writer.write("   Intent intent = new Intent(this,Spot1.class);\n");
	    int imgnum4=imgnum3-1;
	    writer.write("   intent.putExtra(\"imagenum\"," +imgnum4+");\n");
	    writer.write("   startActivity(intent);\n");
	    writer.write("}\n\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }

 //write other to xml file
    for (int imgnum5=startnum;imgnum5<startnum+total;imgnum5++) {
			     try {
            //Whatever the file path is.
            File statText = new File("MainFileXml.txt");
            FileOutputStream is = new FileOutputStream(statText,true);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer writer = new BufferedWriter(osw);
	    writer.write("<TableRow\n");
	    writer.write("       android:layout_width=\"match_parent\"\n");
	    writer.write("       android:layout_height=\"match_parent\">\n\n");
	    writer.write("       <Button\n");
	    writer.write("             android:layout_width=\"wrap_content\"\n");
	    writer.write("             android:layout_height=\"wrap_content\"\n");
	    writer.write("             android:text=\"@string/Spot"+imgnum5+"Btn\"\n");
	    writer.write("             android:id=\"@+id/sp"+imgnum5+"button\"\n");
	    writer.write("             android:onClick=\"spot"+imgnum5+"\"\n");
	    writer.write("             android:layout_column=\"0\" />\n\n");
	    writer.write("    </TableRow>\n\n");
	    writer.write("\n\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }


    //write other to xml file
    for (int imgnum6=startnum;imgnum6<startnum+total;imgnum6++) {
			     try {
            //Whatever the file path is.
            File statText = new File("stringop.txt");
            FileOutputStream is = new FileOutputStream(statText,true);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer writer = new BufferedWriter(osw);
	    writer.write("<string name=\"Spot"+imgnum6+"Btn\">Challenge "+imgnum6+"</string>\n");
            writer.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file statsTest.txt");
        }
    }



}
}
