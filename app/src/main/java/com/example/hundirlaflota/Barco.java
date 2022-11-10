package com.example.hundirlaflota;

public class Barco {
    private int[] barco;
    private int tamano, pos_X, pos_Y;
    private char orientacion;

    public Barco(int tam, Celda c, char orientacion) {
        barco = new int[tam];
        for (int i = 0; i < barco.length; i++) {
            barco[i] = 0;
        }
        this.tamano = tam;
        this.pos_X = c.getPosX();
        this.pos_Y = c.getPosY();
        this.orientacion = orientacion;
    }

    public Barco(int tam, int x, int y, char orientacion) {
        barco = new int[tam];
        for (int i = 0; i < barco.length; i++) {
            barco[i] = 0;
        }
        this.tamano = tam;
        this.pos_X = x;
        this.pos_Y = y;
        this.orientacion = orientacion;
    }

    public boolean iniciaBarcoJugador() {
        boolean result = true;
        int tamanoAux = tamano;
        int cont_X = pos_X;
        int cont_Y = pos_Y;
        int contAux_X = pos_X;
        int contAux_Y = pos_Y;
        int i = 0;
        if (Datos.tablero[pos_X][pos_Y].getValor() == -1) {
            if (orientacion == 'd') {
                if ((pos_X + (tamano - 1)) < Datos.tablero[0].length) {
                    while (i < tamano) {
                        if (Datos.tablero[contAux_X][pos_Y].getValor() == -1) {
                            i++;
                            contAux_X++;
                        } else {
                            result = false;
                        }
                    }
                    if (i == tamano) {
                        while (tamanoAux > 0) {
                            Datos.tablero[cont_X][pos_Y].setBackgroundResource(R.mipmap.barco_verde);
                            Datos.tablero[cont_X][pos_Y].setValor(0);
                            cont_X++;
                            tamanoAux--;
                        }
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            }
            if (orientacion == 'i') {
                if ((pos_X - (tamano - 1)) >= 0) {
                    while (i < tamano) {
                        if (Datos.tablero[contAux_X][pos_Y].getValor() == -1) {
                            i++;
                            contAux_X--;
                        }
                    }
                    if (i == tamano) {
                        while (tamanoAux > 0) {
                            Datos.tablero[cont_X][pos_Y].setBackgroundResource(R.mipmap.barco_verde);
                            Datos.tablero[cont_X][pos_Y].setValor(0);
                            cont_X--;
                            tamanoAux--;
                        }
                    }
                } else {
                    result = false;
                }
            }
            if (orientacion == 't') {
                if ((pos_Y - (tamano - 1)) >= 0) {
                    while (i < tamano) {
                        if (Datos.tablero[pos_X][contAux_Y].getValor() == -1) {
                            i++;
                            contAux_Y--;
                        }
                    }
                    if (i == tamano) {
                        while (tamanoAux > 0) {
                            Datos.tablero[pos_X][cont_Y].setBackgroundResource(R.mipmap.barco_verde);
                            Datos.tablero[pos_X][cont_Y].setValor(0);
                            cont_Y--;
                            tamanoAux--;
                        }
                    }
                } else {
                    result = false;
                }
            }
            if (orientacion == 'b') {
                if ((pos_Y + (tamano - 1)) < Datos.tablero.length) {
                    while (i < tamano) {
                        if (Datos.tablero[pos_X][contAux_Y].getValor() == -1) {
                            i++;
                            contAux_Y++;
                        } else {
                            result = false;
                        }
                    }
                    if (i == tamano) {
                        while (tamanoAux > 0) {
                            Datos.tablero[pos_X][cont_Y].setBackgroundResource(R.mipmap.barco_verde);
                            Datos.tablero[pos_X][cont_Y].setValor(0);
                            cont_Y++;
                            tamanoAux--;
                        }
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            }
        } else {
            result = false;
        }
        return result;
    }


    public boolean iniciaBarcoIA() {
        boolean result = true;
        int tamanoAux = tamano;
        int cont_X = pos_X;
        int cont_Y = pos_Y;
        int contAux_X = pos_X;
        int contAux_Y = pos_Y;
        int i = 0;
        if (Datos.tablero1[pos_X][pos_Y].getValor() == -1) {
            if (orientacion == 'd') {
                if ((pos_X + (tamano - 1)) < Datos.tablero1[0].length) {
                    while (i < tamano) {
                        if (Datos.tablero1[contAux_X][pos_Y].getValor() == -1) {
                            i++;
                            contAux_X++;
                        } else {
                            result = false;
                        }
                    }
                    if (i == tamano) {
                        while (tamanoAux > 0) {
                            Datos.tablero1[cont_X][pos_Y].setBackgroundResource(R.mipmap.barco_rojo);
                            Datos.tablero1[cont_X][pos_Y].setValor(0);
                            cont_X++;
                            tamanoAux--;
                        }
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            }
            if (orientacion == 'i') {
                if ((pos_X - (tamano - 1)) >= 0) {
                    while (i < tamano) {
                        if (Datos.tablero1[contAux_X][pos_Y].getValor() == -1) {
                            i++;
                            contAux_X--;
                        }
                    }
                    if (i == tamano) {
                        while (tamanoAux > 0) {
                            Datos.tablero1[cont_X][pos_Y].setBackgroundResource(R.mipmap.barco_rojo);
                            Datos.tablero1[cont_X][pos_Y].setValor(0);
                            cont_X--;
                            tamanoAux--;
                        }
                    }
                } else {
                    result = false;
                }
            }
            if (orientacion == 't') {
                if ((pos_Y - (tamano - 1)) >= 0) {
                    while (i < tamano) {
                        if (Datos.tablero1[pos_X][contAux_Y].getValor() == -1) {
                            i++;
                            contAux_Y--;
                        }
                    }
                    if (i == tamano) {
                        while (tamanoAux > 0) {
                            Datos.tablero1[pos_X][cont_Y].setBackgroundResource(R.mipmap.barco_rojo);
                            Datos.tablero1[pos_X][cont_Y].setValor(0);
                            cont_Y--;
                            tamanoAux--;
                        }
                    }
                } else {
                    result = false;
                }
            }
            if (orientacion == 'b') {
                if ((pos_Y + (tamano - 1)) < Datos.tablero1.length) {
                    while (i < tamano) {
                        if (Datos.tablero1[pos_X][contAux_Y].getValor() == -1) {
                            i++;
                            contAux_Y++;
                        } else {
                            result = false;
                        }
                    }
                    if (i == tamano) {
                        while (tamanoAux > 0) {
                            Datos.tablero1[pos_X][cont_Y].setBackgroundResource(R.mipmap.barco_rojo);
                            Datos.tablero1[pos_X][cont_Y].setValor(0);
                            cont_Y++;
                            tamanoAux--;
                        }
                    } else {
                        result = false;
                    }
                } else {
                    result = false;
                }
            }
        } else {
            result = false;
        }
        return result;
    }

    public int[] getBarco() {
        return barco;
    }

    public int getPos_X() {
        return pos_X;
    }

    public int getPos_Y() {
        return pos_Y;
    }

    public int getTamano() {
        return tamano;
    }

}
