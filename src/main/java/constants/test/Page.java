package constants.test;

public enum Page {

    WHO_WILL_OWN_MACHINES         ("https://medium.com/@NebulaDAO/who-will-own-machines-4859409b6d81"),
    NEBULA_DAO                    ("https://map.nebuladao.xyz/"),
    ELECTRON_TOGO_APP             ("https://electrontogo.app/map"),
    STELLAR_EVOLUTION             ("https://en.wikipedia.org/wiki/Stellar_evolution"),
    DISCORD                       ("https://discord.com/invite/BdX6rKAjuU"),
    TWITTER                       ("https://twitter.com/nebuladao"),
    MEDIUM                        ("https://medium.com/@NebulaDAO");



    public final String route;

    Page(String route) {
        this.route = route;
    }
}
