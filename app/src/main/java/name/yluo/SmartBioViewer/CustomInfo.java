package name.yluo.SmartBioViewer;

public class CustomInfo {
    public enum Target {
        TNF_alpha, IFN_gama, IL_6
    }
    public enum TestMode {
        SERUM, SALIVA, URINE
    }
    public static Target target = Target.IFN_gama;
    public static TestMode testMode = TestMode.SALIVA;
}
