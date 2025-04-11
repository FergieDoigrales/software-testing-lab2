import functions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public abstract class ModuleTest {
    protected static final double EPSILON = 1e-15;


    protected static SineFunction sinMock;
    protected static CosineFunction cosMock;
    protected static TangentFunction tanMock;
    protected static CosecantFunction cscMock;
    protected static NaturalLogarithm lnMock;
    protected static Logarithm logBase2Mock;
    protected static Logarithm logBase5Mock;
    protected static Logarithm logBase10Mock;

    protected static Logarithm logBase2WithLnMock;
    protected static Logarithm logBase5WithLnMock;
    protected static Logarithm logBase10WithLnMock;

    protected static CosineFunction cosineWithSinMock;
    protected static TangentFunction tangentWithSinAndCosMock;
    protected static CosecantFunction cosecantWithSinMock;


    protected static NaturalLogarithm nL;
    protected static Logarithm logBase2;
    protected static Logarithm logBase5;
    protected static Logarithm logBase10;
    protected static SineFunction sine;
    protected static CosineFunction cosine;
    protected static TangentFunction tangent;
    protected static CosecantFunction cosecant;


    @BeforeAll
    static void setUpMocks() {
        sinMock = mock(SineFunction.class);
        cosMock = mock(CosineFunction.class);
        tanMock = mock(TangentFunction.class);
        cscMock = mock(CosecantFunction.class);
        lnMock = mock(NaturalLogarithm.class);

        logBase2Mock = mock(Logarithm.class);
        logBase5Mock = mock(Logarithm.class);
        logBase10Mock = mock(Logarithm.class);

        logBase2WithLnMock = new Logarithm(lnMock, 2);
        logBase5WithLnMock = new Logarithm(lnMock, 5);
        logBase10WithLnMock = new Logarithm(lnMock, 10);

        cosineWithSinMock = new CosineFunction(sinMock);
        tangentWithSinAndCosMock = new TangentFunction(sinMock, cosMock);
        cosecantWithSinMock = new CosecantFunction(sinMock);

        sine = new SineFunction();
        nL = new NaturalLogarithm();
        logBase2 = new Logarithm(nL, 2);
        logBase5 = new Logarithm(nL, 5);
        logBase10 = new Logarithm(nL, 10);
        cosine = new CosineFunction(sine);
        tangent = new TangentFunction(sine, cosine);
        cosecant = new CosecantFunction(sine);

        when(sinMock.calculate(-0.973622, EPSILON)).thenReturn(-0.8269278129793861);
        when(sinMock.calculate(-1.032997, EPSILON)).thenReturn(-0.8588380488265);
        when(sinMock.calculate(-0.904557, EPSILON)).thenReturn(-0.7861514430821398);
        when(sinMock.calculate(-1.0965, EPSILON)).thenReturn(-0.8896143182382581);
        when(sinMock.calculate(-0.802, EPSILON)).thenReturn(-0.7187480686775715);
        when(sinMock.calculate(-2.50374, EPSILON)).thenReturn(-0.5954716883773244);
        when(sinMock.calculate(-2.459, EPSILON)).thenReturn(-0.6308068851347083);
        when(sinMock.calculate(-2.547, EPSILON)).thenReturn(-0.5601713646870371);
        when(sinMock.calculate(-3.82473, EPSILON)).thenReturn(0.6312294404100668);

        when(cosMock.calculate(-0.973622, EPSILON)).thenReturn(0.5623080935938318);
        when(cosMock.calculate(-1.032997, EPSILON)).thenReturn(0.5122472116936201);
        when(cosMock.calculate(-0.904557, EPSILON)).thenReturn(0.6180339056555628);
        when(cosMock.calculate(-1.0965, EPSILON)).thenReturn(0.45671256254396947);
        when(cosMock.calculate(-0.802, EPSILON)).thenReturn(0.6952706047088867);
        when(cosMock.calculate(-2.50374, EPSILON)).thenReturn(-0.8033762931161578);
        when(cosMock.calculate(-2.459, EPSILON)).thenReturn(-0.7759398647231929);
        when(cosMock.calculate(-2.547, EPSILON)).thenReturn(-0.8283767513545165);
        when(cosMock.calculate(-3.82473, EPSILON)).thenReturn(-0.7755961536518822);

        when(sinMock.calculate(-0.973622, EPSILON/2)).thenReturn(-0.8269278129793861);
        when(sinMock.calculate(-1.032997, EPSILON/2)).thenReturn(-0.8588380488265);
        when(sinMock.calculate(-0.904557, EPSILON/2)).thenReturn(-0.7861514430821398);
        when(sinMock.calculate(-1.0965, EPSILON/2)).thenReturn(-0.8896143182382581);
        when(sinMock.calculate(-0.802, EPSILON/2)).thenReturn(-0.7187480686775715);
        when(sinMock.calculate(-2.50374, EPSILON/2)).thenReturn(-0.5954716883773244);
        when(sinMock.calculate(-2.459, EPSILON/2)).thenReturn(-0.6308068851347083);
        when(sinMock.calculate(-2.547, EPSILON/2)).thenReturn(-0.5601713646870371);
        when(sinMock.calculate(-3.82473, EPSILON/2)).thenReturn(0.6312294404100668);

        when(cosMock.calculate(-0.973622, EPSILON/2)).thenReturn(0.5623080935938318);
        when(cosMock.calculate(-1.032997, EPSILON/2)).thenReturn(0.5122472116936201);
        when(cosMock.calculate(-0.904557, EPSILON/2)).thenReturn(0.6180339056555628);
        when(cosMock.calculate(-1.0965, EPSILON/2)).thenReturn(0.45671256254396947);
        when(cosMock.calculate(-0.802, EPSILON/2)).thenReturn(0.6952706047088867);
        when(cosMock.calculate(-2.50374, EPSILON/2)).thenReturn(-0.8033762931161578);
        when(cosMock.calculate(-2.459, EPSILON/2)).thenReturn(-0.7759398647231929);
        when(cosMock.calculate(-2.547, EPSILON/2)).thenReturn(-0.8283767513545165);
        when(cosMock.calculate(-3.82473, EPSILON/2)).thenReturn(-0.7755961536518822);


//        when(tanMock.calculate(0, EPSILON)).thenReturn(0.0);

        when(tanMock.calculate(-0.973622, EPSILON)).thenReturn(-1.4705956083511316);
        when(tanMock.calculate(-1.032997, EPSILON)).thenReturn(-1.6766085382621476);
        when(tanMock.calculate(-0.904557, EPSILON)).thenReturn(-1.2720199262340643);
        when(tanMock.calculate(-1.0965, EPSILON)).thenReturn(-1.947864786733585);
        when(tanMock.calculate(-0.802, EPSILON)).thenReturn(-1.03376737605427);
        when(tanMock.calculate(-2.50374, EPSILON)).thenReturn(0.7412114266747811);
        when(tanMock.calculate(-2.459, EPSILON)).thenReturn(0.8129584698676887);
        when(tanMock.calculate(-2.547, EPSILON)).thenReturn(0.6762277716885167);
        when(tanMock.calculate(-3.82473, EPSILON)).thenReturn(-0.8138635518471);

//        when(cscMock.calculate(0, EPSILON)).thenThrow(ArithmeticException.class);

        when(cscMock.calculate(-0.973622, EPSILON)).thenReturn(-1.2092953995549407);
        when(cscMock.calculate(-1.032997, EPSILON)).thenReturn(-1.1643638767127047);
        when(cscMock.calculate(-0.904557, EPSILON)).thenReturn(-1.272019543816466);
        when(cscMock.calculate(-1.0965, EPSILON)).thenReturn(-1.124082627155);
        when(cscMock.calculate(-0.802, EPSILON)).thenReturn(-1.3913080863506255);
        when(cscMock.calculate(-2.50374, EPSILON)).thenReturn(-1.6793409653530724);
        when(cscMock.calculate(-2.459, EPSILON)).thenReturn(-1.5852712193945868);
        when(cscMock.calculate(-2.547, EPSILON)).thenReturn(-1.785168009362084);
        when(cscMock.calculate(-3.82473, EPSILON)).thenReturn(1.5842100130031453);

//        when(lnMock.calculate(1, EPSILON)).thenReturn(0.0);

        when(lnMock.calculate(0.02, EPSILON)).thenReturn(-3.912023005428146);
        when(lnMock.calculate(0.02458, EPSILON)).thenReturn(-3.7058221748442484);
        when(lnMock.calculate(0.05, EPSILON)).thenReturn(-2.995732273554);
        when(lnMock.calculate(0.08454, EPSILON)).thenReturn(-2.470530483843493);
        when(lnMock.calculate(0.13, EPSILON)).thenReturn(-2.0402208285265546);
        when(lnMock.calculate(0.8, EPSILON)).thenReturn(-0.2231435513142097);
        when(lnMock.calculate(1, EPSILON)).thenReturn(0.0);
        when(lnMock.calculate(1.1, EPSILON)).thenReturn(0.09531017980432493);
        when(lnMock.calculate(2, EPSILON)).thenReturn(0.6931471805599453);

        when(lnMock.calculate(5, EPSILON)).thenReturn(1.609438);
        when(lnMock.calculate(10, EPSILON)).thenReturn(2.302585);


//        when(logBase10Mock.calculate(1, EPSILON)).thenReturn(0.0);

        when(logBase10Mock.calculate(0.02, EPSILON)).thenReturn(-1.698970004336);
        when(logBase10Mock.calculate(0.02458, EPSILON)).thenReturn(-1.6094181214495646);
        when(logBase10Mock.calculate(0.05, EPSILON)).thenReturn(-1.301029995664);
        when(logBase10Mock.calculate(0.08454, EPSILON)).thenReturn(-1.072937756507);
        when(logBase10Mock.calculate(0.13, EPSILON)).thenReturn(-0.8860566476931632);
        when(logBase10Mock.calculate(0.8, EPSILON)).thenReturn(-0.09691001300805639);
        when(logBase10Mock.calculate(1, EPSILON)).thenReturn(0.0);
        when(logBase10Mock.calculate(1.1, EPSILON)).thenReturn(0.04139268515822507);
        when(logBase10Mock.calculate(2, EPSILON)).thenReturn(0.3010299956639812);

        when(logBase5Mock.calculate(0.02, EPSILON)).thenReturn(-2.430677);
        when(logBase5Mock.calculate(0.02458, EPSILON)).thenReturn(-2.302557);
        when(logBase5Mock.calculate(0.05, EPSILON)).thenReturn(-1.86135);
        when(logBase5Mock.calculate(0.08454, EPSILON)).thenReturn(-1.53503);
        when(logBase5Mock.calculate(0.13, EPSILON)).thenReturn(-1.26766);
        when(logBase5Mock.calculate(0.8, EPSILON)).thenReturn(-0.138647);
        when(logBase5Mock.calculate(1, EPSILON)).thenReturn(0.0);
        when(logBase5Mock.calculate(1.1, EPSILON)).thenReturn(0.0592195);
        when(logBase5Mock.calculate(2, EPSILON)).thenReturn(0.430676558073393);

        when(logBase2Mock.calculate(0.02, EPSILON)).thenReturn(-5.643856189774724);
        when(logBase2Mock.calculate(0.02458, EPSILON)).thenReturn(-5.3463712740641505);
        when(logBase2Mock.calculate(0.05, EPSILON)).thenReturn(-4.321928094887363);
        when(logBase2Mock.calculate(0.08454, EPSILON)).thenReturn(-3.564222077406);
        when(logBase2Mock.calculate(0.13, EPSILON)).thenReturn(-2.9434164716336326);
        when(logBase2Mock.calculate(0.8, EPSILON)).thenReturn(-0.3219280948873623);
        when(logBase2Mock.calculate(1, EPSILON)).thenReturn(0.0);
        when(logBase2Mock.calculate(1.1, EPSILON)).thenReturn(0.1375035237499349);
        when(logBase2Mock.calculate(2, EPSILON)).thenReturn(1.0);

    }
}
