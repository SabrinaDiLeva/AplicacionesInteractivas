import React, {useContext } from "react";
// import Logo from "./minicomponents/Logo";
import style from './Header.module.css'
import data from './headerInfo.json'
import Logo from '../ui/logo.png'
import { UserContext } from "../../hooks/UseContext";


const Header = (props) => {

  // usar session storage
  const loggedUser = useContext(UserContext);
  const randomSloganIndex = Math.round(Math.random() * 3);

  return (
    <>
      <div class={style.header}>
        <div className={style.headerContainer}>
        
          <div class={style.headerLogo}>
            <a className={style.link} href='/'>
              <div className={style.LogoSlogan}>
                <img className={style.images} src={Logo} alt={props.nombre}/>
                <span className={style.slogan}> {data[randomSloganIndex].slogan} </span>
              {/* termina logoSlogan */}
              </div> 
            </a>
          {/* termina headerLogo */}
          </div>

          <div className={loggedUser ? style.sessionIniciada : style.iniciarSession}>
            <div className={style.usuarioSessionIniciada}>
                <div class={style.avatar}>MF</div>
              <span className={style.perfilUsuario}>
                <p className={style.saludo}>Hola,</p>
                <a className={style.linkPerfil} href="/">Marcos Ferro</a>
                {/* <a className={style.cerrarSession} href="/">Cerrar Sesión</a> */}
              </span>
            {/* cierra usuarioSessionIniciada */}
            </div>

            <div className={style.usuarioIniciarSession}>
              <button className={style.linkInicioSession} href="/" type="button">Iniciar Sesion</button>
              <button className={style.linkInicioSession} href="/" type="button">Registrarse</button>                    
            {/* cierra usuarioIniciarSession */}
            </div>
          </div>


        {/* cierra headerContainer */}
        </div>  
      {/* cierra header */}
      </div>
    </>
  );
};

export default Header;

