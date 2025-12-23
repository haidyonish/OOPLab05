import functions.*;
import functions.basic.*;
import functions.meta.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== СОЗДАНИЕ ФУНКЦИЙ =====");

        TabulatedFunction arrayFunc1 =
                new ArrayTabulatedFunction(new FunctionPoint[]{
                        new FunctionPoint(0.0, 1.0),
                        new FunctionPoint(1.0, 2.0),
                        new FunctionPoint(2.0, 3.0)
                });

        TabulatedFunction arrayFunc2 =
                new ArrayTabulatedFunction(new FunctionPoint[]{
                        new FunctionPoint(0.0, 1.0),
                        new FunctionPoint(1.0, 2.0),
                        new FunctionPoint(2.0, 3.0)
                });

        TabulatedFunction listFunc =
                new LinkedListTabulatedFunction(new FunctionPoint[]{
                        new FunctionPoint(0.0, 1.0),
                        new FunctionPoint(1.0, 2.0),
                        new FunctionPoint(2.0, 3.0)
                });

        System.out.println();

        // ─────────────────────────────
        // toString()
        // ─────────────────────────────

        System.out.println("===== toString() =====");
        System.out.println("arrayFunc1:");
        System.out.println(arrayFunc1);

        System.out.println("arrayFunc2:");
        System.out.println(arrayFunc2);

        System.out.println("listFunc:");
        System.out.println(listFunc);

        System.out.println();

        // ─────────────────────────────
        // equals()
        // ─────────────────────────────

        System.out.println("===== equals() =====");
        System.out.println("arrayFunc1.equals(arrayFunc2): " +
                arrayFunc1.equals(arrayFunc2));

        System.out.println("arrayFunc1.equals(listFunc): " +
                arrayFunc1.equals(listFunc));

        System.out.println("arrayFunc2.equals(listFunc): " +
                arrayFunc2.equals(listFunc));

        System.out.println();

        // ─────────────────────────────
        // hashCode()
        // ─────────────────────────────

        System.out.println("===== hashCode() =====");
        System.out.println("arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
        System.out.println("arrayFunc2.hashCode(): " + arrayFunc2.hashCode());
        System.out.println("listFunc.hashCode(): " + listFunc.hashCode());

        System.out.println();

        System.out.println("Изменяем одну точку arrayFunc1 (y += 0.001)");
        arrayFunc1.setPointY(1, arrayFunc1.getPointY(1) + 0.001);

        System.out.println("arrayFunc1.hashCode() после изменения: " +
                arrayFunc1.hashCode());
        System.out.println("arrayFunc2.hashCode() (без изменений): " +
                arrayFunc2.hashCode());

        System.out.println();

        // ─────────────────────────────
        // clone()
        // ─────────────────────────────

        System.out.println("===== clone() =====");

        TabulatedFunction arrayClone =
                (TabulatedFunction) arrayFunc2.clone();

        TabulatedFunction listClone =
                (TabulatedFunction) listFunc.clone();

        System.out.println("arrayFunc2:");
        System.out.println(arrayFunc2);
        System.out.println("arrayClone:");
        System.out.println(arrayClone);

        System.out.println();

        System.out.println("listFunc:");
        System.out.println(listFunc);
        System.out.println("listClone:");
        System.out.println(listClone);

        System.out.println();

        System.out.println("Изменяем исходные объекты после клонирования");

        arrayFunc2.setPointY(0, 100.0);
        listFunc.setPointY(0, 200.0);

        System.out.println("arrayFunc2 (изменён):");
        System.out.println(arrayFunc2);
        System.out.println("arrayClone (должен остаться прежним):");
        System.out.println(arrayClone);

        System.out.println();

        System.out.println("listFunc (изменён):");
        System.out.println(listFunc);
        System.out.println("listClone (должен остаться прежним):");
        System.out.println(listClone);

        System.out.println();
        System.out.println("===== ПРОВЕРКА ЗАВЕРШЕНА =====");
    }
}
