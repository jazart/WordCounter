/**
 * Created by jazart on 11/16/2016.
 */
public class Word implements Comparable<Word>{

    private Integer frequency;
    private String word = "";

    public Word(){
        this.word = "none";
        this.frequency = 0;
    }

    public Word(String word, int frequency){
        this.word = word;
        this.frequency = frequency;
    }

    public void setFrequency(int frequency){
        this.frequency = frequency;
    }

    public void setWord(String word){
        this.word = word;
    }

    public String getWord(){
        return this.word;
    }

    public int getFrequency(){
        return this.frequency;
    }

    @Override
    public int compareTo(Word wordObj){
        if(this.frequency.compareTo(wordObj.getFrequency()) >0){
            return -1;
        }
        else if(this.frequency.compareTo(wordObj.getFrequency())<0){
            return 1;
        }
        return 0;
    }
}
