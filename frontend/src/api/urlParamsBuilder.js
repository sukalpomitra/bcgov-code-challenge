const UrlBuilder = () => {
    let url;
    let queryParams;
    let pathParams;
    let sortingParams;
  
    /**
     * @namespace
     * @property {Function} setUrl - Sets the URL.
     * @property {Function} setQueryParams - Sets the query parameters.
     * @property {Function} setPathParams - Sets the path parameters.
     * @property {Function} setSortingParams - Sets the sorting parameters.
     * @property {Function} build - Builds the URL query.
     */
    const builder = {
      setUrl: (newUrl) => {
        url = newUrl;
        return builder;
      },
      setQueryParams: (newQueryParams) => {
        queryParams = newQueryParams;
        return builder;
      },
      setPathParams: (newPathParams) => {
        pathParams = newPathParams;
        return builder;
      },
      setSortingParams: (newSortingParams) => {
        sortingParams = newSortingParams;
        return builder;
      },
      build: () => {
        return urlQueryBuilder(url, {
          queryParams,
          pathParams,
          sortingParams,
        });
      },
    };
    return builder;
  };
  
  /**
   * Builds the URL query.
   * @param {string} endPoint - The endpoint to build the query.
   * @param {Object} pageableRequestParamState - The state of pageable request parameters.
   * @returns {string} The built URL query.
   * @throws {Error} Throws an error if the endpoint or the pageable request param state is empty.
   */
  const urlQueryBuilder = (endPoint, pageableRequestParamState) => {
    let url = endPoint;
    if (!endPoint) {
      throw Error("Endpoint must not be empty");
    }
    if (!pageableRequestParamState) {
      throw Error("Pageable request param state must not be empty");
    }
  
    const { queryParams, pathParams, sortingParams } = pageableRequestParamState;
  
    if (queryParams && typeof queryParams === "object") {
      const params = Object.keys(queryParams);
      params.forEach((key) => {
        url = updateQueryStringParameter(url, key, queryParams[key]);
      });
    }
  
    if (pathParams && typeof pathParams === "object") {
      url = interpolateUrl(url, pathParams);
    }
  
    if (sortingParams) {
      const { orderDirection, orderBy } = sortingParams;
      if (orderBy) {
        url = updateQueryStringParameter(
          url,
          "sort",
          `${orderBy.field},${(orderDirection || "").toUpperCase()}`
        );
      }
    }
    return url;
  };
  
  /**
   * Interpolates a string URL with provided values.
   * @param {string} string - The string to be interpolated.
   * @param {Object} values - The values used for interpolation.
   * @returns {string} The interpolated string.
   */
  const interpolateUrl = (string, values) =>
    string.replace(/{(.*?)}/g, (match, offset) => values[offset]);
  
  /**
   * Updates a query string parameter in the URI.
   * @param {string} uri - The URI to be updated.
   * @param {string} key - The key of the parameter to update.
   * @param {string} value - The value to update the parameter with.
   * @returns {string} The updated URI.
   */
  const updateQueryStringParameter = (uri, key, value) => {
    const re = new RegExp(`([?&])${key}=.*?(&|$)`, "i");
    const separator = uri.indexOf("?") !== -1 ? "&" : "?";
    if (uri.match(re)) {
      return uri.replace(re, `$1${key}=${value}$2`);
    }
  
    return `${uri + separator + key}=${value}`;
  };
  
  export default UrlBuilder;
  