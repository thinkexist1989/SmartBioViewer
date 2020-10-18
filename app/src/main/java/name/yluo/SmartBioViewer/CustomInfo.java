package name.yluo.SmartBioViewer;

public class CustomInfo {
    public enum Target {
        IFH8, IL6, TNFALPHA, TNFBETA, IL10
    }
    public enum TestMode {
        SALIVA, URINE
    }
    public static Target target = Target.IFH8;
    public static TestMode testMode = TestMode.SALIVA;
}
