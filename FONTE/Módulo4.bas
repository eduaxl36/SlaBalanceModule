Attribute VB_Name = "Módulo4"
Sub MC_NM()
Attribute MC_NM.VB_ProcData.VB_Invoke_Func = " \n14"
'
' MC_NM Macro
'

'
    Sheets(Array("CAM", "GOI", "BHZ", "GRJ", "GSP", "DFE", "CTA", "FLO", "POA", "FOR", "REC", _
        "SAL", "GBE", "MAN", "GVI", "PNT")).Select
    Sheets("CAM").Activate
    ActiveWindow.SmallScroll Down:=-42
    Range("A4:B4").Select
    With Selection
        .HorizontalAlignment = xlGeneral
        .VerticalAlignment = xlBottom
        .WrapText = False
        .Orientation = 0
        .AddIndent = False
        .IndentLevel = 0
        .ShrinkToFit = False
        .ReadingOrder = xlContext
    End With
    Selection.UnMerge
    Range("A4").Select
    Selection.Cut
    Range("B4").Select
    ActiveSheet.Paste
    Columns("B:B").EntireColumn.AutoFit
    Range("A5:A36").Select
    ActiveWindow.SmallScroll Down:=-39
    Columns("A:A").Select
    Range("A3").Activate
    Selection.Delete Shift:=xlToLeft
    ActiveWindow.SmallScroll Down:=3
    Rows("13:24").Select
    Selection.Delete Shift:=xlUp
    ActiveWindow.SmallScroll Down:=-9
    Rows("1:3").Select
    Range("B1").Activate
    Selection.Delete Shift:=xlUp
    Range("A5").Select
    ActiveCell.FormulaR1C1 = "DE"
    Range("A10").Select
    Range("E9").Select
    ActiveWindow.SmallScroll Down:=3
    Range("B25").Select
    ActiveCell.FormulaR1C1 = "TF15"
    Range("B26").Select
    ActiveCell.FormulaR1C1 = "TF35"
    Range("B27").Select
    ActiveCell.FormulaR1C1 = "TF50"
    Range("B25").Select
    ActiveCell.FormulaR1C1 = "DC15"
    Range("B26").Select
    ActiveCell.FormulaR1C1 = "DC35"
    Range("B27").Select
    ActiveCell.FormulaR1C1 = "DC50"
    Range("B28").Select
    ActiveCell.FormulaR1C1 = "T1"
    Range("B29").Select
    ActiveCell.FormulaR1C1 = "T3"
    Range("B30").Select
    ActiveCell.FormulaR1C1 = "T5"
    Rows("31:32").Select
    Selection.Delete Shift:=xlUp
    Range("B31").Select
    ActiveCell.FormulaR1C1 = "QTV1"
    Range("B32").Select
    ActiveCell.FormulaR1C1 = "QTV2"
    Rows("33:34").Select
    Selection.Delete Shift:=xlUp
    Rows("13:24").Select
    Selection.Delete Shift:=xlUp
    Range("B9").Select
    ActiveCell.FormulaR1C1 = "CABLETEM"
    Range("B10").Select
    ActiveCell.FormulaR1C1 = "CABLENT"
    Range("B11").Select
    ActiveCell.FormulaR1C1 = "CRITEM"
    Range("B12").Select
    ActiveCell.FormulaR1C1 = "CRINT"
    Range("B8").Select
    ActiveCell.FormulaR1C1 = "DE"
    Range("B5").Select
    ActiveCell.FormulaR1C1 = "AB"
    Rows("1:3").Select
    Range("C1").Activate
    Selection.Delete Shift:=xlUp
    Rows("18:55").Select
    Selection.Delete Shift:=xlUp
    ActiveWindow.SmallScroll Down:=-30
    Columns("O:CW").Select
    Selection.Delete Shift:=xlToLeft
    Range("A1").Select
    ActiveCell.FormulaR1C1 = "VARI"
    Cells.Select
    Selection.ColumnWidth = 12.57
    Cells.EntireColumn.AutoFit
    Selection.RowHeight = 11.25
    Cells.EntireRow.AutoFit
    Range("A1").Select
    ActiveCell.FormulaR1C1 = "VAR"
    Cells.Select
    Selection.Copy
    Range("A1").Select
    Selection.PasteSpecial Paste:=xlPasteValues, Operation:=xlNone, SkipBlanks _
        :=False, Transpose:=False
    Sheets("GOI").Select
    ActiveWindow.SmallScroll Down:=-36
    Sheets("CAM").Select
End Sub
