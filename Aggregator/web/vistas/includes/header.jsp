<%@taglib prefix="s" uri="/struts-tags" %>

<div class="jumbotron text-center" style="margin-bottom:-20px">

                     <a href="
                
            <s:url action="ListaNoticias">
                <s:param name="pag">1</s:param>
            </s:url>

                
                ">
                     
                     <h1>AGGREGATOR</h1>
                     
                     
                     
                     
                     </a> 
    
    <p>Lo agrega TORR</p>
</div>    

<nav class="navbar navbar-expand-md bg-dark navbar-dark justify-content-center">
    <div class="container">

        <div class="dropdown mr-auto">
            <button class="btn btn-primary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Temática seleccionada
            </button>
            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                <a class='dropdown-item' href='#'>Todas</a>
                <a class='dropdown-item' href='#'>Tematica2...</a>
                <a class='dropdown-item' href='#'>Tematica3...</a>
            </div>
        </div>



        <button class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#prueba" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse ml-5" id="prueba">

            <ul class="navbar-nav mx-auto">
                <li class="nav-item">
                    <a class='nav-link' href='#'>Carpetas</a>


                </li>
                <li class="nav-item">
                    <a class='nav-link' href='#'>Gestionar temas y anuncios (admin)</a>
                </li>

            </ul>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="config.php>"><i class="fa fa-cog"></i></a> </li>
                <li class="nav-item"><a class="nav-link" href="logout.php"><i class="fas fa-sign-out-alt"></i></a> </li>

            </ul>
        </div>
    </div>
</nav>

















<!--<div class="modal" id="tareasModal" tabindex="-1">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-body" style="padding:0">
                <button id="cerrarTareasModel" type="button" class="close">
                    <span>&times;</span>
                </button>
                <div class="principal">
                    <div class="wrap">
                        <form class="formulario" action="">
                            <input type="text" id="tareaInput" placeholder="Añadir Tarea">
                            <input type="button" class="boton" id="btn-agregar" value="+ Añadir tarea">
                        </form>
                    </div>
                </div>

                <div class="tareas">
                    <div class="wrap">
                        <ul class="lista" id="lista">
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>-->