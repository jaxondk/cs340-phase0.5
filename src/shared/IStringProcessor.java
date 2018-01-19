package shared;

/**
 * Created by jaxon on 1/16/18.
 */
public interface IStringProcessor {
    String toLC(String s);
    String trim(String s);
    String parseInt(String s) throws NumberFormatException;
}
