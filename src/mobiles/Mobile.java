package mobiles;


public class Mobile {
	private int mobileId;
	private String mobileModel;
	private String mobileBrand;
	private	String mobileRam;
	private String mobileRom;
	private String mobileProcessor; 
	private String mobileBattery;
	private String mobileCamera;
	private String mobileConnectivities;
	private String mobileGPS;
	private String mobileDisplay;
	private String mobileDimensions;
	private int mobilePrice;
	private String availableColors;
	private String attachments;
	private int availableInStack;
	
	public Mobile(String mobileModel, String mobileBrand, String mobileRam, String mobileRom,
			String mobileProcessor, String mobileBattery, String mobileCamera, String mobileConnectivities,
			String mobileGPS, String mobileDisplay, String mobileDimensions, int mobilePrice, String availableColors,
			String attachments, int availableInStack) {
		this.mobileModel = mobileModel;
		this.mobileBrand = mobileBrand;
		this.mobileRam = mobileRam;
		this.mobileRom = mobileRom;
		this.mobileProcessor = mobileProcessor;
		this.mobileBattery = mobileBattery;
		this.mobileCamera = mobileCamera;
		this.mobileConnectivities = mobileConnectivities;
		this.mobileGPS = mobileGPS;
		this.mobileDisplay = mobileDisplay;
		this.mobileDimensions = mobileDimensions;
		this.mobilePrice = mobilePrice;
		this.availableColors = availableColors;
		this.attachments = attachments;
		this.availableInStack = availableInStack;
	}
	
	public Mobile(int mobileId, String mobileModel, String mobileBrand, String mobileRam, String mobileRom,
			String mobileProcessor, String mobileBattery, String mobileCamera, String mobileConnectivities,
			String mobileGPS, String mobileDisplay, String mobileDimensions, int mobilePrice, String availableColors,
			String attachments, int availableInStack) {
		this.mobileId = mobileId;
		this.mobileModel = mobileModel;
		this.mobileBrand = mobileBrand;
		this.mobileRam = mobileRam;
		this.mobileRom = mobileRom;
		this.mobileProcessor = mobileProcessor;
		this.mobileBattery = mobileBattery;
		this.mobileCamera = mobileCamera;
		this.mobileConnectivities = mobileConnectivities;
		this.mobileGPS = mobileGPS;
		this.mobileDisplay = mobileDisplay;
		this.mobileDimensions = mobileDimensions;
		this.mobilePrice = mobilePrice;
		this.availableColors = availableColors;
		this.attachments = attachments;
		this.availableInStack = availableInStack;
	}

	public int getMobileId() {
		return mobileId;
	}
	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}
	public String getMobileModel() {
		return mobileModel;
	}
	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}
	public String getMobileBrand() {
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}
	public String getMobileRam() {
		return mobileRam;
	}
	public void setMobileRam(String mobileRam) {
		this.mobileRam = mobileRam;
	}
	public String getMobileRom() {
		return mobileRom;
	}
	public void setMobileRom(String mobileRom) {
		this.mobileRom = mobileRom;
	}
	public String getMobileProcessor() {
		return mobileProcessor;
	}
	public void setMobileProcessor(String mobileProcessor) {
		this.mobileProcessor = mobileProcessor;
	}
	public String getMobileBattery() {
		return mobileBattery;
	}
	public void setMobileBattery(String mobileBattery) {
		this.mobileBattery = mobileBattery;
	}
	public String getMobileCamera() {
		return mobileCamera;
	}
	public void setMobileCamera(String mobileCamera) {
		this.mobileCamera = mobileCamera;
	}
	public String getMobileConnectivities() {
		return mobileConnectivities;
	}
	public void setMobileConnectivities(String mobileConnectivities) {
		this.mobileConnectivities = mobileConnectivities;
	}
	public String getMobileGPS() {
		return mobileGPS;
	}
	public void setMobileGPS(String mobileGPS) {
		this.mobileGPS = mobileGPS;
	}
	public String getMobileDisplay() {
		return mobileDisplay;
	}
	public void setMobileDisplay(String mobileDisplay) {
		this.mobileDisplay = mobileDisplay;
	}
	public String getMobileDimensions() {
		return mobileDimensions;
	}
	public void setMobileDimensions(String mobileDimensions) {
		this.mobileDimensions = mobileDimensions;
	}
	public int getMobilePrice() {
		return mobilePrice;
	}
	public void setMobilePrice(int mobilePrice) {
		this.mobilePrice = mobilePrice;
	}
	public String getAvailableColors() {
		return availableColors;
	}
	public void setAvailableColors(String availableColors) {
		this.availableColors = availableColors;
	}
	public String getAttachments() {
		return attachments;
	}
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	public int getAvailableInStack() {
		return availableInStack;
	}
	public void setAvailableInStack(int availableInStack) {
		this.availableInStack = availableInStack;
	}
	@Override
	public String toString() {
		return "Mobile [\nmobileId=" + mobileId + ",\n mobileModel=" + mobileModel + ",\n mobileBrand=" + mobileBrand
				+ ",\n mobileRam=" + mobileRam + ",\n mobileRom=" + mobileRom + ",\n mobileProcessor=" + mobileProcessor
				+ ",\n mobileBattery=" + mobileBattery + ",\n mobileCamera=" + mobileCamera + ",\n mobileConnectivities="
				+ mobileConnectivities + ",\n mobileGPS=" + mobileGPS + ",\n mobileDisplay=" + mobileDisplay
				+ ",\n mobileDimensions=" + mobileDimensions + ",\n mobilePrice=" + mobilePrice + ",\n availableColors="
				+ availableColors + ", attachments=" + attachments + ", availableInStack=" + availableInStack
				+  "\n]";
	}
	
	
	
	
}