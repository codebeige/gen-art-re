# gen-art-re

Examples from [Generative Design] created for the browser with [ClojureScript]
and [Reagent]. Unlike the original implementation this project leverages
current web technology only and does use [Processing] at all.

[Generative Design]: http://www.generative-gestaltung.de
[ClojureScript]: https://clojurescript.org
[Reagent]: https://reagent-project.github.io
[Processing]: https://processing.org

## Usage

Build the production bundle:

    boot build

Then open [build/index.html](./build/index.html) in your browser.

## Development

Start up an interactive development environment:

    boot dev

Visit [localhost:3000](http://localhost:3000) and see all changes reflected
live in the browser.

---

Copyright © 2017 Tibor Claassen <tc@codebeige.net>.
Distributed under the [MIT License].

[MIT License]: https://opensource.org/licenses/MIT
