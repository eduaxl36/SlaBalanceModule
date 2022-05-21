Attribute VB_Name = "Módulo5"
Sub P_DE()
Attribute P_DE.VB_ProcData.VB_Invoke_Func = " \n14"
'
' P_DE Macro
'

'
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
        .MergeCells = False
    End With
    Selection.UnMerge
    Range("A4").Select
    Selection.Copy
    Range("B4").Select
    ActiveSheet.Paste
    Range("A4").Select
    Application.CutCopyMode = False
    Selection.ClearContents
    Range("B5").Select
    ActiveCell.FormulaR1C1 = "AB"
    Range("B8").Select
    ActiveCell.FormulaR1C1 = "DE"
    Rows("13:24").Select
    Selection.Delete Shift:=xlUp
    Range("B13").Select
    ActiveCell.FormulaR1C1 = "T15"
    Range("B14").Select
    ActiveCell.FormulaR1C1 = "T35"
    Range("B15").Select
    ActiveCell.FormulaR1C1 = "T50"
    Range("B13").Select
    ActiveCell.FormulaR1C1 = "D15"
    Range("B14").Select
    ActiveCell.FormulaR1C1 = "D35"
    Range("B15").Select
    ActiveCell.FormulaR1C1 = "D50"
    Range("B16").Select
    ActiveCell.FormulaR1C1 = "T1"
    Range("B17").Select
    ActiveCell.FormulaR1C1 = "T3"
    Range("B18").Select
    ActiveCell.FormulaR1C1 = "T5"
    Rows("19:20").Select
    Selection.Delete Shift:=xlUp
    Range("B19").Select
    ActiveCell.FormulaR1C1 = "TV1"
    Range("B20").Select
    ActiveCell.FormulaR1C1 = "TV2"
    Rows("21:22").Select
    Selection.Delete Shift:=xlUp
    Rows("21:21").Select
    Selection.Delete Shift:=xlUp
    Rows("21:56").Select
    Selection.Delete Shift:=xlUp
    Rows("21:21").Select
    Selection.Delete Shift:=xlUp
    ActiveWindow.SmallScroll Down:=-39
    Range("A1:B2").Select
    Columns("B:B").EntireColumn.AutoFit
    Range("A1:B2").Select
End Sub
