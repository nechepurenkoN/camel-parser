package does.not.matter;

import java.lang.*;

class OnlySetBodyRoutes {

    public RouteBuilder getRoutes() {
        return new RouteBuilder(
            @Override
            public void configure() throws Exception {

                from("direct:foo")
                    to("log:bar");

                from("direct:baz")
                    .setBody().constant("foo")
                    .to("log:bar");

            }
        );
    }

    public RouteBuilder getRoutes1() {
        return new RouteBuilder(
            @Override
            public void configure() throws Exception {

                from("direct:foobar")
                    .to("direct:baz")
                    .setBody().constant("foobar baz")
                    .toD("direct:baz")
                    .setBody().constant("foobar " + "baz")
                    .to("direct:baz");

                from("direct:baz")
                    .setBody().constant("foo")
                    .to("log:bar");

            }
        );
    }

}