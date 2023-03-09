package Main.Exeption;

import java.io.Serializable;

public class Not_match_JobsException extends RuntimeException implements Serializable {
    public Not_match_JobsException(String massage){
        super(massage);
    }
    public Not_match_JobsException(){
        super("ERROR : NOT MATCH BETWEEN JOB AND PERSON JOB!");
    }
}
