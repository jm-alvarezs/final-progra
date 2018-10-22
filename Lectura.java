import java.io.*;

class Lectura {
	
	public static byte readByte() {
		DataInputStream x = new DataInputStream (System.in);
      String g;
      byte num = 0;
      boolean valido = true;
      do {
         valido = true;
         try {
            g = x.readLine();
            num = Byte.parseByte(g);
         }catch (IOException e) {
            System.out.println("Error de Captura.");
            g = "0";
         }catch (NumberFormatException e){
            System.out.println("Ingrese un numero entero.");
            valido = false;
         }
      } while(!valido);
      
      return num;
	}
	
	public static short readShort() {
		DataInputStream x = new DataInputStream (System.in);
      String g;
      short num = 0;
      boolean valido = true;
      do {
         valido = true;
         try {
            g = x.readLine();
            num = Short.parseShort(g);
         }catch (IOException e) {
            System.out.println("Error de Captura.");
            g = "0";
         }catch (NumberFormatException e){
            System.out.println("Ingrese un numero entero.");
            valido = false;
         }
      } while(!valido);
      
      return num;
	}
	
	public static int readInt() {
		DataInputStream x = new DataInputStream (System.in);
      String g;
      int num = 0;
      boolean valido = true;
      do {
         valido = true;
         try {
            g = x.readLine();
            num = Integer.parseInt(g);
         }catch (IOException e) {
            System.out.println("Error de Captura.");
            g = "0";
         }catch (NumberFormatException e){
            System.out.println("Ingrese un numero entero.");
            valido = false;
         }
      } while(!valido);
      
      return num;
	}
	
	public static long readLong() {
		DataInputStream x = new DataInputStream (System.in);
      String g;
      long num = 0;
      boolean valido = true;
      do {
         valido = true;
         try {
            g = x.readLine();
            num = Long.parseLong(g);
         }catch (IOException e) {
            System.out.println("Error de Captura.");
        	g = "0";
         }catch (NumberFormatException e){
            System.out.println("Ingrese un numero entero.");
            valido = false;
         }
      } while(!valido);
      
      return num;
	}
	
	public static float readFloat() {
		DataInputStream x = new DataInputStream (System.in);
      String g;
      float num = 0;
      boolean valido = true;
      do {
         valido = true;
         try {
            g = x.readLine();
            num = Integer.parseInt(g);
         }catch (IOException e) {
        	System.out.println("Error de Captura.");
            g = "0";
         }catch (NumberFormatException e){
            System.out.println("Error. Intente de nuevo.");
            valido = false;
         }
      } while(!valido);
      
      return num;
	}
	
	public static double readDouble() {
		DataInputStream x = new DataInputStream (System.in);
      String g;
      double num = 0;
      boolean valido = true;
      do {
         valido = true;
         try {
            g = x.readLine();
            num = Double.parseDouble(g);
         }catch (IOException e) {
        	System.out.println("Error de Captura.");
            g = "0";
         }catch (NumberFormatException e){
             System.out.println("Error. Intente de nuevo.");
             valido = false;
          }
      } while(!valido);
      
      return num;
	}
	
	public static String readString() {
		DataInputStream x = new DataInputStream(System.in);
		String g;
		try {
			g = x.readLine();
		}catch(IOException e) {
            System.out.println("Error de Captura.");
			g = "";
		}
		return g;
	}
	
	public static char readChar() {
		DataInputStream x = new DataInputStream(System.in);
		String g;
		try {
			g = x.readLine();
		}catch(IOException e) {
			g = "";
		}
		char r = g.charAt(0);
		return r;
	}
	
	public static boolean getYesNo() {
		char answer = readChar();
		Character.toLowerCase(answer);
		
		while(answer != 'y' && answer != 'n') {
			System.out.println("SelecciÃ³n no vÃ¡lida.");
			answer = readChar();
			Character.toLowerCase(answer);
		}
		
		if(answer == 'y') {
			return true;
		}
		
		return false;
	}
}
