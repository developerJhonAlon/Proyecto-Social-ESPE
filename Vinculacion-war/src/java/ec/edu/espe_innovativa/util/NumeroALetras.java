package ec.edu.espe_innovativa.util;

import java.util.regex.Pattern;

/**
 * @autor Mouse
 * @web http://jc-mouse.blogspot.com/
 *
 * 
 * @modificado por hug0 (2013-12-31)
 * @web http://garabatoslinux.net
 * modificaciones:
 * - Sintaxis en las cantidades con "un" al principio, eje: un millon, novecientos un millones
 * - Sintaxis arreglada para la cantidad "1". original: "un", modificacion: "uno".
 * - Sintaxis arreglada para las "veintenas". veintiuno, veintidos...
 * - Sintaxis arreglada para las cantidades con "1000", en lugar de "uno mil..." ahora es "mil..."
 * 
 */

public class NumeroALetras {
  private final String[] unidades={"", "uno ", "dos ", "tres ", "cuatro ", 
    "cinco ", "seis ", "siete ", "ocho ", "nueve "};
  private final String[] decenas = {"diez ", "once ", "doce ", "trece ", 
    "catorce ", "quince ", "dieciseis ", "diecisiete ", "dieciocho ", 
    "diecinueve ", "veinte ", "treinta ", "cuarenta ","cincuenta ", 
    "sesenta ", "setenta ", "ochenta ", "noventa "};
  private final String[] centenas = {"", "ciento ", "doscientos ", 
    "trecientos ", "cuatrocientos ", "quinientos ", "seiscientos ",
    "setecientos ", "ochocientos ", "novecientos "};

  public String convertir(String numero, boolean mayusculas){
    String literal="";
    String parte_decimal="";    

    numero=numero.replace(".", ",");

    if(numero.indexOf(",")==-1){
      numero=numero+",00";
    }

    //numeros desde 0.00 hasta 999999999.99
    if(Pattern.matches("\\d{1,9},\\d{1,2}", numero)){
      //separa la parte decimal de la entera
      String num[]=numero.split(",");
      //parte_decimal="con " + num[1]+"/100";

      //selecciona el tipo de transformacion a realizar
      //segun la cantidad numerica
      if(Integer.parseInt(num[0])==0){
        literal="cero";
      }else if(Integer.parseInt(num[0])>999999){
        literal=getMillones(num[0]); //millones
      }else if(Integer.parseInt(num[0])>999){
        literal=getMiles(num[0]); //miles
      }else if(Integer.parseInt(num[0])>99){
        literal=getCentenas(num[0]); //centenas        

      }else if(Integer.parseInt(num[0])>20 && Integer.parseInt(num[0])<30){
        literal=getVeintes(num[0]); //veintenas

      }else if(Integer.parseInt(num[0])>9){
        literal=getDecenas(num[0]); //decenas
      }else{
        literal=getUnidades(num[0]); //unidades
      }

      //si la variable es true se devuelve en mayusculas
      //si la variable es false se devuelve en minusculas
      if(mayusculas){
        return (literal + parte_decimal).toUpperCase();
      }else{
        return (literal + parte_decimal);
      }
    }else{
      return literal=null;
    }
  }

  //Trasforma las "veintenas"
  private String getVeintes(String numero){
    String num=numero.substring(numero.length()-1);
    return "veinti" + unidades[Integer.parseInt(num)];       
  }

  //transforma las unidades
  private String getUnidades(String numero){      
    String num=numero.substring(numero.length()-1);
    return unidades[Integer.parseInt(num)];          
  }

  //transforma las decenas
  private String getDecenas(String num){
    int n=Integer.parseInt(num);
    if(n<10){
      return getUnidades(num);

    }else if(n>20 && n<30){
      String u=getVeintes(num);      
      return u;

    }else if(n>19){
      String u=getUnidades(num);
      if(u.equals("")){
        return decenas[Integer.parseInt(num.substring(0,1))+8];
      }else{
        return decenas[Integer.parseInt(num.substring(0,1))+8]+"y "+u;
      }
    }else{
      return decenas[n-10];
    }
  }

  //transforma las centenas
  private String getCentenas(String num){
    if(Integer.parseInt(num)>99){
      if(Integer.parseInt(num)==100){
        return "cien ";
      }else{
        return centenas[Integer.parseInt(num.substring(0,1))] + getDecenas(num.substring(1));
      }
    }else{
      return getDecenas(Integer.parseInt(num)+"");
    }
  }

  //transforma los miles
  private String getMiles(String num){
    String c=num.substring(num.length()-3);
    String m=num.substring(0,num.length()-3);
    String n="";

    if(Integer.parseInt(m)>0){
      n=getCentenas(m);

      if(n.equals("uno ")){
        n = "";
      }      

      n=n.replace("veintiuno", "veintiun");
      n=n.replace("y uno", "y un");
      n=n.replace("uno", "un");

      return n+"mil "+getCentenas(c);
    }else{
      return ""+getCentenas(c);
    }
  }

  //transforma los millones
  private String getMillones(String num){
    String miles=num.substring(num.length()-6);
    String millon=num.substring(0,num.length()-6);
    String n="";

    if(millon.length()>1){
      n=getCentenas(millon)+"millones ";
    }else{
      //n=getUnidades(millon)+"millon ";
      n="un millon ";
    }

    n=n.replace("uno millones", "un millones");

    return n+getMiles(miles);
  }
}