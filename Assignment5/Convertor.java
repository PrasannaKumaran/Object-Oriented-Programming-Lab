package convertor;
public class Convertor
{	private float Dollar;
	private float Yen;
	private float INR;
	public Convertor()
	{
		this.Dollar = 0.0f;
		this.Yen = 0.0f;
		this.INR = 0.0f;
	}
	public float getDollar()
	{
		return Dollar;
	}
	public float getYen()
	{
		return Yen;
	}
	public float getINR()
	{
		return INR;
	}
	public float INR_to_Yen(float in) 
	{
		return	1.49f * in;
	}
	public float INR_to_Dollar(float in) 
	{
		return	0.014f * in;
	}
	public float Yen_to_INR(float yen) 
	{
		return	0.67f * yen;
	}
	public float Yen_to_Dollar(float yen) 
	{
		return	0.0094f * yen;
	}
	public float Dollar_to_INR(float dol) 
	{
		return	71.60f * dol;
	}
	public float Dollar_to_Yen(float dol) 
	{
		return	106.29f * dol;
	} 
}
