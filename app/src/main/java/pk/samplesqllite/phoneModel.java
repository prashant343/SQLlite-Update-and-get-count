package pk.samplesqllite;

/**
 * Created by prashantkaushik on 12/01/17.
 */

public class phoneModel {


    String _id;
    String phonemodelname;
    String memorysize;

    //basic, empty constturctor
    public phoneModel()
    {

    }

    public phoneModel(String _id) {
        this._id = _id;
    }


    //setter method
    public phoneModel(String id, String name, String memory)
    {
        this._id = id;
        this.phonemodelname = name;
        this.memorysize = memory;



    }





    //getter methods
public String getID()
{
    return this._id;

}
    public String getphonemodel()
    {
        return this.phonemodelname;

    }
    public String getmemorysize()
    {
        return this.memorysize;


    }







}
