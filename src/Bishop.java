public class Bishop /*SLON*/extends ChessPiece {
    public Bishop(String color) {
        super(color);
//        check=true;
    }
    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard,
                                     int line, int column, int toLine, int toColumn) {

        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        }
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        int deltaLine = Integer.signum(toLine - line);
        int deltaColumn = Integer.signum(toColumn - column);
        int currentLine = line + deltaLine;
        int currentColumn = column + deltaColumn;

        while (currentLine != toLine && currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += deltaLine;
            currentColumn += deltaColumn;
        }


        if ((toLine >= 0 && toLine <= 7 && toColumn >= 0 && toColumn <= 7 ) &&
                (Math.abs(line - toLine) == (Math.abs(column - toColumn))) &&
                (line != toLine || column != toColumn)) {
            return true;
        }

        return false;
    }
    @Override
    public String getColor() {
        return color;
    }
    @Override
    public String getSymbol() {
        return "B";
    }
}