import java.util.List;
import java.util.ArrayList;

public class IntergalacticTransmission {

    public static List<Integer> getTransmitSequence(List<Integer> message) {
        if(message.size() == 0) return message;
        int totalSize = 8, bitCounter = 0, onseCounter = 0, itr = 0;
        char padchar = '0';
        String parityBits = "", processedBits = "", subString = "";
        
        List<Integer> parityTransmission = new ArrayList<>();
        
        for(int i : message){
            String bits = Integer.toBinaryString(i);
            bits = String.valueOf(padchar).repeat(totalSize - bits.length()) + bits;
           

            parityBits += bits;
        }

        while(itr < parityBits.length()){
            if(bitCounter == 7){
                if(onseCounter % 2 == 0){
                    processedBits += '0';
                }
                else{
                    processedBits += '1';
                }
                bitCounter = 0;
                onseCounter = 0;
            }
            bitCounter++;
            if(parityBits.charAt(itr) == '1') onseCounter++;
            processedBits += parityBits.charAt(itr);
            itr++;
        }

        processedBits = processedBits + String.valueOf('0').repeat(7 - (processedBits.length() % 8));
        processedBits = processedBits + ((onseCounter % 2) == 0 ? '0' : '1');
        
        itr = 0;
        while(itr < processedBits.length()){
            subString += processedBits.charAt(itr);
            if(subString.length() == 8){
                //check if output is correct 
                //System.out.println(subString);
                parityTransmission.add(Integer.parseInt(subString, 2));
                subString = "";
            }
            itr++;
        }
            
        return parityTransmission;
    }

    public static List<Integer> decodeSequence(List<Integer> sequence) {
        if(sequence.size() < 2) return sequence;

        String removeBits = "", mainString = "";
        List<Integer> outPut = new ArrayList<>();
        int bitCounter = 0, countOnse = 0, itr = 0;
        
        for(int i : sequence){
            String bits = Integer.toBinaryString(i);
            removeBits += String.valueOf('0').repeat(8 - bits.length()) + bits;
        }

        //System.out.println(removeBits);
        for(int i = 0; i < removeBits.length(); i++){
            if(bitCounter == 7){
                if((countOnse % 2 == 0 && removeBits.charAt(i) != '0')||
                   (countOnse % 2 != 0 & removeBits.charAt(i) != '1')){
                    throw new IllegalArgumentException("invalid sequence!");
                }
                else{
                    bitCounter = 0;
                    countOnse = 0;
                    continue;
                }
            }
            if(removeBits.charAt(i) == '1'){
                countOnse++;
            }
            mainString += removeBits.charAt(i);
            bitCounter++;
        }
        //System.out.println(mainString);
        mainString = mainString.substring(0, mainString.length() - (mainString.length() % 8));
        
        //System.out.println(mainString);

        String trmp = "";
        while(itr < mainString.length() - 1){
            trmp += mainString.charAt(itr);
              
            if(trmp.length() == 8){
                outPut.add(Integer.parseInt(trmp, 2));
                trmp = "";
            }
            itr++;
        }
        //System.out.println(trmp);
    
        trmp += mainString.charAt(mainString.length() - 1);
        if(itr != 0){
            outPut.add(Integer.parseInt(trmp, 2));
        }
        return outPut;
    }





















    
}
