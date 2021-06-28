package com.innovatesolutions.organizetorneios.api;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

/**
 * Classe de apoio contendo métodos que podem ser reutilizadas no projeto
 * <p>
 * Criada por Luis Borba - 06/2020
 */
public class AppUtil {

    public static final int TIME_SPLASH = 3500;
    public static final String PREF_APP = "app_organize_torneios_pref";
    public static final String LOG_APP1 = "USUARIO_LOG";
    public static final String LOG_APP2 = "EQUIPE_LOG";
    public static final String LOG_APP3 = "GRUPO_LOG";
    public static final String LOG_APP4 = "JOGADOR_LOG";
    public static final String URL_IMG_BACKGROUND = "http://bit.ly/daaziImgBackground";
    public static final String URL_IMG_LOGO = "http://bit.ly/daaziImgLogo";

    /**
     * @return devolve a data atual.
     */
    public static String getDataAtual() {
        String dia, mes, ano;
        String dataAtual = "00/00/0000";

        try {
            Calendar calendar = Calendar.getInstance();
            dia = String.valueOf(calendar.get(Calendar.DAY_OF_MONTH));
            mes = String.valueOf(calendar.get(Calendar.MONTH) + 1);
            ano = String.valueOf(calendar.get(Calendar.YEAR));

            //TODO: conferir em dia do mês menor que 10
            // dia = (Calendar.DAY_OF_MONTH<10) ? "0"+dia : dia;

            dia = (Calendar.DAY_OF_MONTH < 10) ? dia : dia;

            int mesAtual = (Calendar.MONTH) + 1;

            mes = (mesAtual < 10) ? "0" + mes : mes;

            dataAtual = dia + "/" + mes + "/" + ano;

            return dataAtual;

        } catch (Exception e) {

        }
        return dataAtual;
    }

    /**
     * @return devolve a hora atual.
     */

    public static String getHoraAtual() {
        String hora, minuto, segundo;
        String horaAtual = "00:00:00";

        try {
            Calendar calendar = Calendar.getInstance();

            int iHora = calendar.get(Calendar.HOUR_OF_DAY);
            int iMinuto = calendar.get(Calendar.MINUTE);
            int iSegundo = calendar.get(Calendar.SECOND);

            //TODO: conferir em hora do mês menor que 10
            hora = (iHora <= 9) ? "0" + iHora : Integer.toString(iHora);
            minuto = (iMinuto <= 9) ? "0" + iMinuto : Integer.toString(iMinuto);
            segundo = (iSegundo <= 9) ? "0" + iSegundo : Integer.toString(iSegundo);

            horaAtual = hora + ":" + minuto + ":" + segundo;

            return horaAtual;

        } catch (Exception e) {

        }
        return horaAtual;
    }

    /**
     * Gerar senha criptografada com MD5.
     *
     * @param password
     * @return
     */
    public static String gerarMD5Hash(String password) {
        String retorno = "";

        if (!password.isEmpty()) {
            retorno = "falhou";
            try {
                // Create MD5 Hash
                MessageDigest digest = MessageDigest.getInstance("MD5");
                digest.update(password.getBytes());
                byte messageDigest[] = digest.digest();

                StringBuffer MD5Hash = new StringBuffer();
                for (int i = 0; i < messageDigest.length; i++) {
                    String h = Integer.toHexString(0xFF & messageDigest[i]);
                    while (h.length() < 2)
                        h = "0" + h;
                    MD5Hash.append(h);
                }
                return MD5Hash.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return retorno;
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getApplicationInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static void goNextScreen(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
